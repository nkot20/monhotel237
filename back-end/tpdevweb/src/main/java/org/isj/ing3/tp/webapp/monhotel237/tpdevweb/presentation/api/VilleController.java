package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.VilleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Ville;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IVille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ville")
@Slf4j
@Api("ville")
public class VilleController {

    @Autowired
    private IVille iVille;

    @PostMapping(value = "/savecity")
    public ResponseEntity<Void> save(@RequestBody VilleDto villeDto) throws HotelException {
        iVille.addData(villeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getville/{name}")
    public ResponseEntity<Ville> findByName(@PathVariable("name") String name) throws HotelException {
        Ville ville = iVille.searchCityByName(name);
        return ResponseEntity.ok(ville);
    }

    @DeleteMapping("/deltecity/{name}")
    public ResponseEntity<Void> delete(@PathVariable("name") String name) throws HotelException {
        iVille.deleteCityByName(name);
        return ResponseEntity.ok().build();
    }


    @PutMapping(value = "/updateville")
    public ResponseEntity<Void> update(@RequestBody VilleDto villeDto) throws HotelException {
        iVille.update(villeDto);
        return ResponseEntity.ok().build();
    }
}