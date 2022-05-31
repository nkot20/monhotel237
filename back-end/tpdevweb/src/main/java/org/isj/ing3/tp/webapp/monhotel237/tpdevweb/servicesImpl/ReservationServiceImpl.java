package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.List;

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



    @Override
    public ReservationDto addData(ReservationDto reservationDto) throws HotelException {
        reservationDto.setId(new ReservationIdDto(clientMapper.toDto(clientService.searchByEmail(reservationDto.getId().getClient().getEmail())), chambreMapper.toDto(chambreService.searchChambreByNumber(reservationDto.getId().getChambre().getNumero())), reservationDto.getId().getDatedebut()));
        return reservationMapper.toDto(reservationRepository.save(reservationMapper.toEntity(reservationDto)));

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
        return null;
    }
}
