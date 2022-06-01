package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEmploye;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEntretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EntretientController {

    @Autowired
    IEmploye iEmploye;

    @Autowired
    IChambre iChambre;

    @Autowired
    IEntretien iEntretien;

    @GetMapping("/entretien")
    public String pageNettoyageChambre(Model model) {

        List<EmployeDto> employeDtos = iEmploye.getAll();
        List<ChambreDto> chambreDtos = iChambre.listChambres();
        List<EntretienDto> entretienDtos = iEntretien.listentretien();
        EntretienDto entretienDto = new EntretienDto();

        model.addAttribute("employeDtos", employeDtos);
        model.addAttribute("chambreDtos", chambreDtos);
        model.addAttribute("entretienDtos", entretienDtos);
        model.addAttribute("entretienDto", entretienDto);
        model.addAttribute("entretienDtoUpdate", new EntretienDto());

        return "nettoyagesdeschambres";
    }

    @PostMapping("/enregistrernettoyage")
    public String enregistrerNettoyageChambre(@ModelAttribute EntretienDto entretienDto) throws HotelException {

        iEntretien.addData(entretienDto);

        return "redirect:/entretien";
    }

    @GetMapping("/supprimernettoyage")
    public String supprimernettoyage(@RequestParam(value = "numero", defaultValue = "") Integer numero) throws HotelException {
        iEntretien.deleteByNumber(numero);

        return "redirect:/entretien";
    }

    @GetMapping("/modifiernettoyageform")
    public String modifiernettoyageForm(@RequestParam(value = "numero", defaultValue = "") Integer numero, Model model) throws HotelException {
        EntretienDto entretienDto = iEntretien.searchEntretienByNumeroDto(numero);
        List<EmployeDto> employeDtos = iEmploye.getAll();
        List<ChambreDto> chambreDtos = iChambre.listChambres();

        model.addAttribute("employeDtos", employeDtos);
        model.addAttribute("chambreDtos", chambreDtos);
        model.addAttribute("entretienDto", entretienDto);
        return "modifiernettoyage";
    }

    @PostMapping(value = "/modifiernetoyage")
    public String modifierNettoyage(@ModelAttribute EntretienDto entretienDto) throws HotelException {
        System.out.println(entretienDto);
        iEntretien.update(entretienDto);

        return "redirect:/entretien";
    }
}