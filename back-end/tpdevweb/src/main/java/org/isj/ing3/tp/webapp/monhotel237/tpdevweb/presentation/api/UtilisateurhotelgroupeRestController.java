package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IUtilisateurHotelGroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.UtilisateurhotelgroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/utilisateurhotelgroupe")
@RestController
@Slf4j
@Api("utilisateurhotelgroupe")
public class UtilisateurhotelgroupeRestController {

    @Autowired
    private IUtilisateurHotelGroupe iUtilisateurHotelGroupe;

    @PostMapping("/adduser")
    public ResponseEntity<Void> save(@RequestBody UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        iUtilisateurHotelGroupe.addData(utilisateurhotelgroupeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getuser/{email}")
    public ResponseEntity<Utilisateurhotelgroupe> findByEmail(@PathVariable("email") String email) throws HotelException {
        Utilisateurhotelgroupe utilisateurhotelgroupe = iUtilisateurHotelGroupe.searchByEmail(email);
        return ResponseEntity.ok(utilisateurhotelgroupe);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UtilisateurhotelgroupeDto>> getAllUtilisateurhotelgroupe() {
        return ResponseEntity.ok(iUtilisateurHotelGroupe.listUtilisateurhotelgroupeDto());
    }

    @DeleteMapping("/deleteuser/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email) throws HotelException {
        Optional.ofNullable(iUtilisateurHotelGroupe.searchByEmail(email));
        iUtilisateurHotelGroupe.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        iUtilisateurHotelGroupe.update(utilisateurhotelgroupeDto);
        return ResponseEntity.ok().build();
    }
}