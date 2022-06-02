package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IRole;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IUtilisateurHotelGroupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class Utilisateurhotelgroupecontroller {
    @Autowired
    IUtilisateurHotelGroupe iUtilisateurHotelGroupe;

    @Autowired
    IRole iRole;

    @PostMapping("/ajouteruserform")
    public String enregistrerutilisateur(@ModelAttribute UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException, ParseException {
        System.out.println(utilisateurhotelgroupeDto);
        //convertir la date

        iUtilisateurHotelGroupe.addData(utilisateurhotelgroupeDto);

        return "redirect:listeutilisateurhotelgroupe";
    }

    @GetMapping("/ajouter_user")
    public String enregistrerutilisateurForm(Model model)  {
        List<RoleDto> roleDtos = iRole.listRoles();
        UtilisateurhotelgroupeDto utilisateurhotelgroupeDto = new UtilisateurhotelgroupeDto();
        System.out.println(roleDtos);
        model.addAttribute("roleDto", roleDtos);
        model.addAttribute("user", utilisateurhotelgroupeDto);
        return "ajouteruser";
    }

    @GetMapping("/listeutilisateurhotelgroupe")
    public String utilisateurhotelgroupeliste(Model model){
        List<UtilisateurhotelgroupeDto> utilisateurhotelgroupeDtos = iUtilisateurHotelGroupe.listUtilisateurhotelgroupeDto();
        model.addAttribute("utilisateurhotelgroupeDtos", utilisateurhotelgroupeDtos);
        return "listedesutilisateurs";
    }
    @GetMapping("/delete-utilisateurs")
    public String utilisateurSupprime(@RequestParam(name="email")String email, Model model) throws HotelException {
        iUtilisateurHotelGroupe.deleteByEmail(email);
        return "redirect:listedesutilisateurs";
    }

    @GetMapping("/details-utilisateurs")
    public String utilisateurDetail(@RequestParam (name="email") String email, Model model) throws HotelException {
        Utilisateurhotelgroupe utilisateurhotelgroupeDto= iUtilisateurHotelGroupe.searchByEmail(email);
        model.addAttribute("utilisateurhotelgroupeDto",utilisateurhotelgroupeDto);
        return "details-utilisateurs";
    }
}
