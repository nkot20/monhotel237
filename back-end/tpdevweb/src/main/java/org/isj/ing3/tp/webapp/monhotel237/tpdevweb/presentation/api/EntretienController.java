package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
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

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated EntretienDto entretienDto) {
        entretienService.save(entretienDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntretienDto> findById(@PathVariable("id") Integer id) throws HotelException {
        EntretienDto entretien = entretienService.findById(id);
        return ResponseEntity.ok(entretien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws HotelException {
        Optional.ofNullable(entretienService.findById(id));
        entretienService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated EntretienDto entretienDto) throws HotelException {
        entretienService.update(entretienDto);
        return ResponseEntity.ok().build();
    }
}