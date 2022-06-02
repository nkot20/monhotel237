package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ChambreMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ClientMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ReservationMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.RoleMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ReservationDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ReservationIdDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.ReservationRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.RoleRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IReservation;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.FactureReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements IReservation {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private ChambreServiceImpl chambreService;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ChambreMapper chambreMapper;

    private byte[] bytes ;




    @Override
    public ReservationDto addData(ReservationDto reservationDto) throws HotelException, JRException, FileNotFoundException {
        Client client = new Client();
        Chambre chambre = new Chambre();
        try {
            client = clientService.searchByEmail(reservationDto.getId().getClient().getEmail());
            chambre = chambreService.searchChambreByNumber(reservationDto.getId().getChambre().getNumero());

        } catch (HotelException e) {
            ClientDto clientDto = clientService.addData(reservationDto.getId().getClient());
            client = clientService.searchByEmail(clientDto.getEmail());
            chambre = chambreService.searchChambreByNumber(reservationDto.getId().getChambre().getNumero());
        }
        System.out.println(reservationDto);
        System.out.println(reservationMapper.toEntity(reservationDto));
        Reservation reservation = reservationMapper.toEntity(reservationDto);
        reservation.setId(new ReservationId(client, chambre, reservationDto.getId().getDatedebut()));

        Reservation newReservation = reservationRepository.save(reservation);

        //facture
        String prix = reservation.getId().getChambre().getCategoriechambre().getPrix();
        float totalJour = diffDate(reservation.getId().getDatedebut(), reservation.getDatefin());
        float total = totalJour * Float.parseFloat(prix);
        String nom = client.getNom() + client.getPrenom();
        String email = client.getEmail();
        String tel = client.getTel1();

        bytes = generatedPdf(new FactureReservation(reservation.getId().getChambre().getCategoriechambre().getLibelle(), reservation.getId().getDatedebut().toString(), reservation.getDatefin().toString(), prix, String.valueOf(totalJour), String.valueOf(total), nom, email, tel));
        ReservationDto newReservationDto = reservationMapper.toDto(reservation);
        return reservationDto;

    }

    @Override
    public ReservationDto searchById(Integer id) throws HotelException {

        return null;

    }

    @Override
    public ReservationDto update(ReservationDto reservationDto) throws HotelException {

        reservationDto.setId(new ReservationIdDto(clientMapper.toDto(clientService.searchByEmail(reservationDto.getId().getClient().getEmail())), chambreMapper.toDto(chambreService.searchChambreByNumber(reservationDto.getId().getChambre().getNumero())), reservationDto.getId().getDatedebut()));
        return null;
    }

    @Override
    public List<ReservationDto> getAll() {
        return null;
    }

    @Override
    public Entretien searchReservationByNumero(Integer numero) throws HotelException {
        return null;
    }

    @Override
    public void deleteByNumber(Integer number) throws HotelException {

    }

    @Override
    public List<ReservationDto> listreservation() {
        return reservationMapper.toDto(reservationRepository.findAll());
    }

    @Override
    public List<ChambreDto> listeChambreDispos(Date datebebut, Date datefin) throws HotelException {
        List<ChambreDto> chambreDtoNoReservation = chambreService.listRoomNoReserve();
        List<ChambreDto> chambreDtoReservesDisponible = new ArrayList<ChambreDto>();
        listreservation().stream().forEach(reservationDto -> {
            if (reservationDto.getDatefin().before(datebebut)) {
                chambreDtoReservesDisponible.add(reservationDto.getId().getChambre());
            }
        });
        chambreDtoReservesDisponible.addAll(chambreDtoNoReservation);
        return chambreDtoReservesDisponible;
    }

    @Override
    public byte[] generatedPdf(FactureReservation reservation) throws JRException, FileNotFoundException {
        List<FactureReservation> factureReservations = new ArrayList<FactureReservation>();
        factureReservations.add(reservation);
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(factureReservations);
        JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/hotel.jrxml"));

        HashMap<String, Object> map = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, jrBeanCollectionDataSource);
        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

        return data;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }

    private float diffDate(Date datedebut, Date datefin) {
        long diff = datefin.getTime() - datedebut.getTime();
        return  (diff/(1000*60*60*24));
    }
}
