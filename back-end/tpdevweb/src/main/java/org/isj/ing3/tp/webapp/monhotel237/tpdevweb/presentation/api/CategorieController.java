package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ResourceNotFoundException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categorie")
@Slf4j
@Api("categorie")
public class CategorieController {

    @Autowired
    private ICategorie iCategorie;

    @PostMapping(value = "/savecat")
    public ResponseEntity<Void> save(@RequestBody CategorieDto categorieDto) throws HotelException {
        System.out.println("categorieDto.getIntitule()");
        iCategorie.addData(categorieDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findcat/{intitule}")
    public ResponseEntity<CategorieDto> findByIntitule(@PathVariable("intitule") String intitule) throws HotelException {
        CategorieDto categorie = iCategorie.searchCategorieByIntitule2(intitule);
        return ResponseEntity.ok(categorie);
    }

    @DeleteMapping("/deletecat/{intitule}")
    public ResponseEntity<Void> delete(@PathVariable("intitule") String intitule) throws HotelException {
        iCategorie.deleteByIntitule(intitule);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/updatecat")
    public ResponseEntity<Void> update(@RequestBody CategorieDto categorieDto) throws HotelException {
        iCategorie.update(categorieDto);
        return ResponseEntity.ok().build();
    }
}