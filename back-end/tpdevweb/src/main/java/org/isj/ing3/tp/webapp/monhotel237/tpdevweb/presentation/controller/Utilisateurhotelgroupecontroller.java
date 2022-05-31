package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IUtilisateurHotelGroupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public class Utilisateurhotelgroupecontroller {
    @Autowired
    IUtilisateurHotelGroupe iUtilisateurHotelGroupe;

    @GetMapping("/liste-des-utilisations")
    public String pageliste(Model model){
        List<UtilisateurhotelgroupeDto> utilisateurhotelgroupeDtos = iUtilisateurHotelGroupe.listUtilisateurhotelgroupeDto();
        model.addAttribute("utilisateurHotelgroupDtos",utilisateurhotelgroupeDtos);
        return "liste-des-utilisations";
    }

}
