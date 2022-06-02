package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorie;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorieChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class CategorieController {

    @Autowired
    ICategorieChambre iCategorieChambre;

    @GetMapping("/listcategories")
    public String pageCategorie(Model model) {
        List<CategoriechambreDto>categoriechambreDtos = iCategorieChambre.listCategoriechambres();
        model.addAttribute("categoriechambreDtos", categoriechambreDtos);
        model.addAttribute("categoriechambreDto", new CategoriechambreDto()) ;

        return "categories";

    }

    //Traitemement des valeurs saisies dans le formulaire
    @PostMapping("/enregistrercategorie")
    public String enregistrerCategorie(@ModelAttribute CategoriechambreDto categoriechambreDto, Model model) throws HotelException {

        iCategorieChambre.addData(categoriechambreDto);

        return "redirect:/listcategories";
    }

    @RequestMapping(value = "/image/{data}")
    public ResponseEntity<byte[]> getImage(@PathVariable("data") byte[] data) {
        System.out.println(data);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
    }


    @GetMapping("/modifiercategorieform")
    public String modifiercategorieForm(@RequestParam(value = "libelle", defaultValue = "") String libelle, Model model) throws HotelException {
        CategoriechambreDto categoriechambreDto = iCategorieChambre.searchCategoriechambreByLibelle2(libelle);

        System.out.println(categoriechambreDto);
        model.addAttribute("categoriechambreDto", categoriechambreDto);

        return "modifiercategorie";

    }

    //Modifier les informations d'une catégorie
    @PostMapping(value = "/modifierCategorie")
    public String modifierCategorie(@ModelAttribute CategoriechambreDto categoriechambreDto) throws HotelException {
        System.out.println(categoriechambreDto);
        iCategorieChambre.update(categoriechambreDto);

        return "redirect:/listcategories";
    }

    @GetMapping("/supprimercategorie")
    public String supprimercategorie(@RequestParam(value = "libelle", defaultValue = "") String libelle) throws HotelException {
        iCategorieChambre.deleteByLibelle(libelle);

        return "redirect:/listcategories";
    }
}
