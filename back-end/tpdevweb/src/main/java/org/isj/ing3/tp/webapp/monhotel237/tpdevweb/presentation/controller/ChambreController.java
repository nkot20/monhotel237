package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorieChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEntretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@Slf4j

public class ChambreController {

    @Autowired
    IChambre iChambre;

    @Autowired
    ICategorieChambre iCategorieChambre;

    @GetMapping("/listchambres")
    public String pageChambre(Model model) {

        List<ChambreDto> chambreDtos = iChambre.listChambres();
        List<CategoriechambreDto> categoriechambreDtos = iCategorieChambre.listCategoriechambres();

        model.addAttribute("categoriechambreDtos", categoriechambreDtos);
        model.addAttribute("categoriechambreDto", new CategoriechambreDto());
        model.addAttribute("chambreDtos", chambreDtos);
        model.addAttribute("chambreDto", new ChambreDto()) ;

        return "listedeschambres";

    }

    //Traitemement des valeurs saisies dans le formulaire
    @PostMapping("/enregistrerchambre")
    public String enregistrerChambre(@ModelAttribute ChambreDto chambreDto, Model model) throws HotelException, JRException, FileNotFoundException {
        chambreDto.setUsername("Pami Kelly");
        iChambre.addData(chambreDto);

        return "redirect:/listchambres";
    }

    @GetMapping("/modifierchambreform")
    public String modifierchambreForm(@RequestParam(value = "numero", defaultValue = "") Integer numero, Model model) throws HotelException {

        ChambreDto chambreDto= iChambre.searchChambreByNumberDto(numero);
        List<ChambreDto> chambreDtos = iChambre.listChambres();
        List<CategoriechambreDto> categoriechambreDtos = iCategorieChambre.listCategoriechambres();


        System.out.println(chambreDto);
        model.addAttribute("chambreDto", chambreDto);
        model.addAttribute("chambreDtos", chambreDtos);
        model.addAttribute("categoriechambreDtos", categoriechambreDtos);
        //model.addAttribute("categoriechambreDto", new CategoriechambreDto());

        return "modifierchambre";

    }

    //Modifier les informations d'une catégorie
    @PostMapping(value = "/modifierChambre")
    public String modifierChambre(@ModelAttribute ChambreDto chambreDto) throws HotelException {
        System.out.println(chambreDto);
        iChambre.update(chambreDto);

        return "redirect:/listchambres";
    }

    @GetMapping("/supprimerchambre")
    public String supprimerchambre(@RequestParam(value = "numero", defaultValue = "") Integer numero) throws HotelException {
        iChambre.deleteByNumber(numero);

        return "redirect:/listchambres";
    }

}
