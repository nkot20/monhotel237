package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.EntretienService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/entretien")
@RestController
@Slf4j
@Api("entretien")
public class EntretienController {
    private final EntretienService entretienService;

    public EntretienController(EntretienService entretienService) {
        this.entretienService = entretienService;
    }

    @PostMapping("/saveentretien")
    public ResponseEntity<Void> save(@RequestBody EntretienDto entretienDto) throws HotelException {
        entretienService.addData(entretienDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getentretien/{number}")
    public ResponseEntity<Entretien> findByNumber(@PathVariable("number") Integer number) throws HotelException {
        Entretien entretien = entretienService.searchEntretienByNumero(number);
        return ResponseEntity.ok(entretien);
    }

    @DeleteMapping("/deleteentretien/{number}")
    public ResponseEntity<Void> delete(@PathVariable("number") Integer number) throws HotelException {
        entretienService.deleteByNumber(number);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/deleteentretien")
    public ResponseEntity<Void> update(@RequestBody EntretienDto entretienDto) throws HotelException {
        entretienService.update(entretienDto);
        return ResponseEntity.ok().build();
    }
}