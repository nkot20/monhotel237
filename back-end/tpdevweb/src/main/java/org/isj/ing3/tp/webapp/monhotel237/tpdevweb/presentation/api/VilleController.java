package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.VilleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.VilleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/ville")
@RestController
@Slf4j
@Api("ville")
public class VilleController {
    private final VilleService villeService;

    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated VilleDto villeDto) {
        villeService.save(villeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VilleDto> findById(@PathVariable("id") Integer id) throws HotelException {
        VilleDto ville = villeService.findById(id);
        return ResponseEntity.ok(ville);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws HotelException {
        Optional.ofNullable(villeService.findById(id));
        villeService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated VilleDto villeDto, @PathVariable("id") Integer id) throws HotelException {
        villeService.update(villeDto);
        return ResponseEntity.ok().build();
    }
}