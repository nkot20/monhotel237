package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {

    @GetMapping("/accueil")
    public String pageAccueil(Model model) {

        return "menu";
    }

}
