package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.UtilisateurhotelgroupeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/utilisateurhotelgroupe")
@RestController
@Slf4j
@Api("utilisateurhotelgroupe")
public class UtilisateurhotelgroupeController {
    private final UtilisateurhotelgroupeService utilisateurhotelgroupeService;

    public UtilisateurhotelgroupeController(UtilisateurhotelgroupeService utilisateurhotelgroupeService) {
        this.utilisateurhotelgroupeService = utilisateurhotelgroupeService;
    }

    @PostMapping("/adduser")
    public ResponseEntity<Void> save(@RequestBody UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        utilisateurhotelgroupeService.addData(utilisateurhotelgroupeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getuser/{email}")
    public ResponseEntity<Utilisateurhotelgroupe> findByEmail(@PathVariable("email") String email) throws HotelException {
        Utilisateurhotelgroupe utilisateurhotelgroupe = utilisateurhotelgroupeService.searchByEmail(email);
        return ResponseEntity.ok(utilisateurhotelgroupe);
    }

    @DeleteMapping("/deleteuser/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email) throws HotelException {
        Optional.ofNullable(utilisateurhotelgroupeService.searchByEmail(email));
        utilisateurhotelgroupeService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        utilisateurhotelgroupeService.update(utilisateurhotelgroupeDto);
        return ResponseEntity.ok().build();
    }
}