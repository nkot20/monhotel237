package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEmploye;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEntretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeController {

    @Autowired
    IEmploye iEmploye;


    @GetMapping("/listemployes")
    public String pageListClients(Model model) {
       // getAuthentificationContext(model);
        List<EmployeDto> employeDtos = iEmploye.listEmployes();
        model.addAttribute("employeDtos", employeDtos);
        return "listedesemployes";
    }

    @GetMapping("/saveemployeform")
    public String saveEmployeForm(Model model)  {
        //getAuthentificationContext(model);
        EmployeDto employeDto = new EmployeDto();
        employeDto.setUser("Francine");
        model.addAttribute("employeDto", employeDto);
        return "ajouteremploye";
    }

    // Traitemement des valeurs saisies dans le formulaire
    @PostMapping("/saveemploye")
    public String saveEmploye(@ModelAttribute EmployeDto employeDto,
                                  Model model) throws HotelException {
        //getAuthentificationContext(model);
        iEmploye.saveEmploye(employeDto);
        return "redirect:/listemployes";
    }

    @GetMapping("/details")
    public String pageDetail(@RequestParam(value = "nom", defaultValue = "") String nom, Model model) throws HotelException {
        //getAuthentificationContext(model);
        EmployeDto employeDto = iEmploye.searchByNomDto(nom);
        model.addAttribute("employeDto", employeDto);
        return "detailsdesemployes";
    }

    @PostMapping("/editeremploye")
    public String editerEmploye(@ModelAttribute EmployeDto employeDto,
                             Model model) throws HotelException {
        //getAuthentificationContext(model);
        iEmploye.updateEmployeDto(employeDto);
        return "redirect:/listemployes";
    }

    @GetMapping("/modifieremployeform")
    public String modifierEmployeForm(@RequestParam(value = "nom", defaultValue = "") String nom, Model model) throws HotelException {
        //getAuthentificationContext(model);
        EmployeDto employeDto = iEmploye.searchByNomDto(nom);
        model.addAttribute("employeDto", employeDto);
        return "modifieremploye";
    }

    // Traitemement des valeurs saisies dans le formulaire d'édition

    @GetMapping("/supprimeremploye")
    public String pageListeApresSuppression(@RequestParam(value = "email", defaultValue = "") String email, Model model) throws HotelException {
        //getAuthentificationContext(model);
        int result = iEmploye.deleteByEmail(email);
        return "redirect:/listemployes";
    }

   /* @GetMapping("/supprimer")
    public String pageListeApresSuppression(@RequestParam(value = "numero", defaultValue = "") String numero, Model model) {
        getAuthentificationContext(model);
        //appel de la couche service pour supprimer un acte
        int result = iActe.deleteActe(numero);

        return "redirect:/listactes";
    }*/



}
