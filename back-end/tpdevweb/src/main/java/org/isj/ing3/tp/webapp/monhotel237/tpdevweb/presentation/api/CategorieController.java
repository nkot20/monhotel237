package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ResourceNotFoundException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.CategorieServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/categorie")
@RestController
@Slf4j
@Api("categorie")
public class CategorieController {
    private final CategorieServiceImpl categorieService;

    public CategorieController(CategorieServiceImpl categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated CategorieDto categorieDto) {
        categorieService.addData(categorieDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieDto> findById(@PathVariable("id") Integer id) throws HotelException {
        CategorieDto categorie = categorieService.searchById(id);
        return ResponseEntity.ok(categorie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws HotelException {
        Optional.ofNullable(categorieService.searchById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException("Unable to delete non-existent data！");
        });
        categorieService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated CategorieDto categorieDto) throws HotelException {
        categorieService.update(categorieDto);
        return ResponseEntity.ok().build();
    }
}