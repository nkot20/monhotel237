package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Hotel;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEmploye;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class HotelController {

    @Autowired
    IHotel iHotel;

    @GetMapping("/accueil")
    public String pageAccueil(Model model) {

        return "menu";
    }
    @GetMapping("/detailhotel")
    public String pageDetail(@RequestParam(name = "email") String email, Model model) throws HotelException {


        List<HotelDto> hotelDtos = iHotel.getAll();
        Hotel hotelDto = iHotel.searchByEmail(email);


        model.addAttribute("hotelDto", hotelDto);
        return null;
    }

    @GetMapping("/deletehotel")
    public String pageSupprimer(@RequestParam(name = "email") String email, Model model) throws HotelException {

        iHotel.deleteByEmail(email);

        return "redirect:/accueil";
    }



    @GetMapping("/enregistrerhotelform")
    public String pageEnregistrerActeForm(Model model) {

        HotelDto hotelDto=new HotelDto();
        hotelDto.setUser("esta");
        model.addAttribute("hotelDto",hotelDto);

        return "enregistrerhotel";
    }

    @PostMapping("/savehotel")
    public String enregistreracte(@ModelAttribute HotelDto hotelDto,
                                  Model model) throws HotelException {

        //HotelController.log.info("enregistrer-hotel");

         iHotel.addData(hotelDto);
        return "redirect:/accueil";

    }
    @GetMapping("/editerform")
    public String pageEditerForm( Model model) throws HotelException {


        List<HotelDto> hotelDtos=  iHotel.Listhotel();
        if (hotelDtos.isEmpty()){
            return "redirect:/accueil";
        }
        else{
        HotelDto hotelDto= hotelDtos.get(0);

        model.addAttribute("hotelDto", hotelDto);


        return "editerhotel";}
    }


    @PostMapping("/edithotel")
    public String editeracte(@ModelAttribute HotelDto hotelDto,
                             Model model) throws HotelException {

        //HotelController.log.info("edit-hotel");
        iHotel.update(hotelDto);

        return "redirect:/accueil";
    }










}
