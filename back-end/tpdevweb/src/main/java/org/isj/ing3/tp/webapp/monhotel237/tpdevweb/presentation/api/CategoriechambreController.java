package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.CategoriechambreServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/categoriechambre")
@RestController
@Slf4j
@Api("categoriechambre")
public class CategoriechambreController {
    private final CategoriechambreServiceImpl categoriechambreService;

    public CategoriechambreController(CategoriechambreServiceImpl categoriechambreService) {
        this.categoriechambreService = categoriechambreService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated CategoriechambreDto categoriechambreDto) {
        categoriechambreService.addData(categoriechambreDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriechambreDto> findById(@PathVariable("id") Integer id) throws HotelException {
        CategoriechambreDto categoriechambre = categoriechambreService.searchById(id);
        return ResponseEntity.ok(categoriechambre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws HotelException {
        Optional.ofNullable(categoriechambreService.searchById(id));
        categoriechambreService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated CategoriechambreDto categoriechambreDto) throws HotelException {
        categoriechambreService.update(categoriechambreDto);
        return ResponseEntity.ok().build();
    }
}