package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IClient;
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
public class ClientController {

    @Autowired
    IClient iClient;


    @GetMapping("/listclients")
    public String pageListClients(Model model) {
        // getAuthentificationContext(model);
        List<ClientDto> clientDtos = iClient.listClients();
        model.addAttribute("clientDto", clientDtos);
        return "listedesclients";
    }

    /*@GetMapping("/saveclientform")
    public String saveClientForm(Model model)  {
        //getAuthentificationContext(model);
        ClientDto clientDto = new ClientDto();
        clientDto.setUser("Francine");
        model.addAttribute("clientDto", clientDto);
        return "ajouterclient";
    }


    @PostMapping("/saveemploye")
    public String saveEmploye(@ModelAttribute EmployeDto employeDto,
                              Model model) throws HotelException {
        //getAuthentificationContext(model);
        iEmploye.saveEmploye(employeDto);
        return "redirect:/listemployes";
    }*/

    @GetMapping("/detailsclients")
    public String pageDetailClients(@RequestParam(value = "nom", defaultValue = "") String nom, Model model) throws HotelException {
        //getAuthentificationContext(model);
        ClientDto clientDto = iClient.searchByNomDto(nom);
        model.addAttribute("clientDto", clientDto);
        return "detailsdesclients";
    }

    @PostMapping("/editerclient")
    public String editerClient(@ModelAttribute ClientDto clientDto,
                                Model model) throws HotelException {
        //getAuthentificationContext(model);
        iClient.update(clientDto);
        return "redirect:/listclients";
    }

    @GetMapping("/modifierclientform")
    public String modifierClientForm(@RequestParam(value = "nom", defaultValue = "") String nom, Model model) throws HotelException {
        //getAuthentificationContext(model);
        ClientDto clientDto = iClient.searchByNomDto(nom);
        model.addAttribute("clientDto", clientDto);
        return "modifierclient";
    }

    @GetMapping("/supprimerclient")
    public String pageListeApresSuppression(@RequestParam(value = "email", defaultValue = "") String email, Model model) throws HotelException {
        //getAuthentificationContext(model);
        int result = iClient.deleteByEmail(email);
        return "redirect:/listclients";
    }


}


