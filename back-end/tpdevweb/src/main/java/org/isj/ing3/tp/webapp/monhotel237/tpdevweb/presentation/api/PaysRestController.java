package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.PaysDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Pays;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IPays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/pays")
@RestController
@Slf4j
@Api("pays")
public class PaysRestController {

    @Autowired
    private IPays iPays;

    @PostMapping("/savecountry")
    public ResponseEntity<Void> save(@RequestBody PaysDto paysDto) throws HotelException {
        iPays.addData(paysDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getcountry/{nompays}")
    public ResponseEntity<Pays> findById(@PathVariable("nompays") String nompays) throws HotelException {
        Pays pays = iPays.searchPaysByNompays(nompays);
        return ResponseEntity.ok(pays);
    }

    @DeleteMapping("/deletecountry/{nompays}")
    public ResponseEntity<Void> delete(@PathVariable("nompays") String nompays) throws HotelException {
        iPays.deletePaysByNomPays(nompays);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/updatecountry")
    public ResponseEntity<Void> update(@RequestBody PaysDto paysDto) throws HotelException {
        iPays.update(paysDto);
        return ResponseEntity.ok().build();
    }
}