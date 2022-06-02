package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEmploye;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEntretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        model.addAttribute("keyword", "");
        model.addAttribute("error", "");
        return "nettoyagesdeschambres";
    }

    @PostMapping("/enregistrernettoyage")
    public String enregistrerNettoyageChambre(@ModelAttribute EntretienDto entretienDto) throws HotelException, JRException, FileNotFoundException {

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

    @PostMapping("/recherchernettoyage")
    public String rechercherNettoyage(@RequestParam(value = "numerochambre") Integer numerochambre, Model model) throws HotelException {

        List<EmployeDto> employeDtos = iEmploye.getAll();
        List<ChambreDto> chambreDtos = iChambre.listChambres();
        EntretienDto entretienDto = new EntretienDto();

        model.addAttribute("employeDtos", employeDtos);
        model.addAttribute("chambreDtos", chambreDtos);
        model.addAttribute("keyword", "");
        try {
            List<EntretienDto> entretienDtos = iEntretien.searchEntretienByRoom(numerochambre);
            model.addAttribute("entretienDtos", entretienDtos);
            model.addAttribute("error", "");
        } catch (HotelException e) {
            System.out.println(e.getMessage());
            model.addAttribute("entretienDtos", new ArrayList<EntretienDto>());
            model.addAttribute("error", "Aucun nettoyage ne correspond");
        }

        model.addAttribute("entretienDto", new EntretienDto());
        return "nettoyagesdeschambres";
    }


}