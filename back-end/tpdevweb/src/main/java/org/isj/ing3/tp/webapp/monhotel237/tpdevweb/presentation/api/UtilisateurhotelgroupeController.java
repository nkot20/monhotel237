package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
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

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) {
        utilisateurhotelgroupeService.save(utilisateurhotelgroupeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurhotelgroupeDto> findById(@PathVariable("id") Integer id) throws HotelException {
        UtilisateurhotelgroupeDto utilisateurhotelgroupe = utilisateurhotelgroupeService.findById(id);
        return ResponseEntity.ok(utilisateurhotelgroupe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws HotelException {
        Optional.ofNullable(utilisateurhotelgroupeService.findById(id));
        utilisateurhotelgroupeService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated UtilisateurhotelgroupeDto utilisateurhotelgroupeDto, @PathVariable("id") Integer id) throws HotelException {
        utilisateurhotelgroupeService.update(utilisateurhotelgroupeDto);
        return ResponseEntity.ok().build();
    }
}