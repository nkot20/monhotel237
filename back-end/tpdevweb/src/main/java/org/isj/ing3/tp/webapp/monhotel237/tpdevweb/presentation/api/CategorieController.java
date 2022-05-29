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

    @PostMapping("/savecat")
    public ResponseEntity<Void> save(@RequestBody CategorieDto categorieDto) throws HotelException {
        categorieService.addData(categorieDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findcat/{intitule}")
    public ResponseEntity<CategorieDto> findByIntitule(@PathVariable("intitule") String intitule) throws HotelException {
        CategorieDto categorie = categorieService.searchCategorieByIntitule2(intitule);
        return ResponseEntity.ok(categorie);
    }

    @DeleteMapping("/deletecat/{intitule}")
    public ResponseEntity<Void> delete(@PathVariable("intitule") String intitule) throws HotelException {
        Optional.ofNullable(categorieService.searchCategorieByIntitule(intitule)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException("Unable to delete non-existent data！");
        });
        categorieService.deleteByIntitule(intitule);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatecat")
    public ResponseEntity<Void> update(@RequestBody CategorieDto categorieDto) throws HotelException {
        categorieService.update(categorieDto);
        return ResponseEntity.ok().build();
    }
}