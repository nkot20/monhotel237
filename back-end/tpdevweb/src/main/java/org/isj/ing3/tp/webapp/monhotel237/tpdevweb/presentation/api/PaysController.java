package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.PaysDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.PaysService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/pays")
@RestController
@Slf4j
@Api("pays")
public class PaysController {
    private final PaysService paysService;

    public PaysController(PaysService paysService) {
        this.paysService = paysService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated PaysDto paysDto) {
        paysService.addData(paysDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaysDto> findById(@PathVariable("id") Integer id) throws HotelException {
        PaysDto pays = paysService.searchById(id);
        return ResponseEntity.ok(pays);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws HotelException {
        Optional.ofNullable(paysService.searchById(id));
        paysService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated PaysDto paysDto, @PathVariable("id") Integer id) throws HotelException {
        paysService.update(paysDto);
        return ResponseEntity.ok().build();
    }
}