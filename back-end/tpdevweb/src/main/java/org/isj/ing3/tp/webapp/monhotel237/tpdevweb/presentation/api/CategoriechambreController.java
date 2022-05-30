package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorieChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/categoriechambre")
@RestController
@Slf4j
@Api("categoriechambre")
public class CategoriechambreController {

    @Autowired
    private ICategorieChambre iCategorieChambre;

    @PostMapping("/savecategoryroom")
    public ResponseEntity<Void> save(@RequestBody CategoriechambreDto categoriechambreDto) throws HotelException {
        iCategorieChambre.addData(categoriechambreDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findcategoryroom/{libelle}")
    public ResponseEntity<CategoriechambreDto> findByLibelle(@PathVariable("libelle") String libelle) throws HotelException {
        CategoriechambreDto categoriechambre = iCategorieChambre.searchCategoriechambreByLibelle2(libelle);
        return ResponseEntity.ok(categoriechambre);
    }

    @DeleteMapping("/deletecategoryroom/{libelle}")
    public ResponseEntity<Void> delete(@PathVariable("libelle") String libelle) throws HotelException {
        iCategorieChambre.deleteByLibelle(libelle);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/updatecatroom")
    public ResponseEntity<Void> update(@RequestBody CategoriechambreDto categoriechambreDto) throws HotelException {
        iCategorieChambre.update(categoriechambreDto);
        return ResponseEntity.ok().build();
    }
}