package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ResourceNotFoundException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.ChambreServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/chambre")
@RestController
@Slf4j
@Api("chambre")
public class ChambreController {
    private final ChambreServiceImpl chambreService;

    public ChambreController(ChambreServiceImpl chambreService) {
        this.chambreService = chambreService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ChambreDto chambreDto) {
        chambreService.addData(chambreDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChambreDto> findById(@PathVariable("id") Integer id) throws HotelException {
        ChambreDto chambre = chambreService.searchById(id);
        return ResponseEntity.ok(chambre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws HotelException {
        Optional.ofNullable(chambreService.searchById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException("Unable to delete non-existent data！");
        });
        chambreService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ChambreDto chambreDto) throws HotelException {
        chambreService.update(chambreDto);
        return ResponseEntity.ok().build();
    }
}