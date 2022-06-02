package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorieChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    ReservationServiceImpl ireservationService;
    @Autowired
    ICategorieChambre icategorieChambre;

    @GetMapping("/reservationformfirst")
    public String reservationFormFirst(Model model) {
        List<CategoriechambreDto> categoriechambresDtos = icategorieChambre.listCategoriechambres();
        System.out.println(categoriechambresDtos);
        model.addAttribute("categorieschambreDtos", categoriechambresDtos);
        model.addAttribute("reservationDto", new ReservationDto());
        model.addAttribute("nbchambredispo", 0);
        return "reservationhotelfirst";
    }

    @PostMapping(value = "/rechercherchambredispo")
    public String chambresDispo(@RequestParam("datedebut") String dateDebut, @RequestParam("datefin") String dateFin, Model model) throws HotelException {
        try {

            List<CategoriechambreDto> categoriechambresDtos = icategorieChambre.listCategoriechambres();
            Date datedebut1 = (new SimpleDateFormat("dd-MM-yyyy")).parse(dateDebut);
            Date datefin1 = (new SimpleDateFormat("dd-MM-yyyy")).parse(dateFin);
            List<ChambreDto> chambreDtos = ireservationService.listeChambreDispos(datedebut1, datefin1);
            model.addAttribute("nbchambredispo", chambreDtos.size());
            model.addAttribute("reservationDto", new ReservationDto());
            model.addAttribute("categorieschambreDtos", categoriechambresDtos);
        } catch (HotelException | ParseException e) {
            model.addAttribute("nbchambredispo", 0);
        }

        return "reservationhotelfirst";
    }

    @PostMapping(value = "/goreservationsecond")
    public String reservationSecond(@ModelAttribute ReservationDto reservationDto, Model model) {
        System.out.println(reservationDto);
        model.addAttribute("reservationDto", reservationDto);
        return "reservationhotelsecond";
    }

    @PostMapping(value = "/goreservationthird")
    public String reservationThird(@ModelAttribute ReservationDto reservationDto, Model model) throws HotelException {

        List<ChambreDto> chambreDtosForCategorieClient = new ArrayList<ChambreDto>();
        ireservationService.listeChambreDispos(reservationDto.getId().getDatedebut(), reservationDto.getDatefin()).forEach(chambreDto -> {
            if (chambreDto.getCategoriechambre().getLibelle().equals(reservationDto.getType())) {
                chambreDtosForCategorieClient.add(chambreDto);
            }
        });

        model.addAttribute("chambreDtos", chambreDtosForCategorieClient);
        model.addAttribute("reservationDto", reservationDto);
        return "reservationhotelsethird";
    }

    @PostMapping(value = "/savereservation")
    public ResponseEntity<byte[]> savereservation(@ModelAttribute ReservationDto reservationDto, Model model) throws HotelException, JRException, FileNotFoundException {

        ireservationService.addData(reservationDto);

        byte[] data = ireservationService.getBytes();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=facture.pdf");
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(data);

    }

    /*@GetMapping(value = "/inforeservationclient")
    public String inforeservationclient()*/



}
