package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEntretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RequestMapping("/api/entretien")
@RestController
@Slf4j
@Api("entretien")
public class EntretienRestController {

    @Autowired
    private IEntretien iEntretien;

    @PostMapping("/saveentretien")
    public ResponseEntity<Void> save(@RequestBody EntretienDto entretienDto) throws HotelException, JRException, FileNotFoundException {
        iEntretien.addData(entretienDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getentretien/{number}")
    public ResponseEntity<Entretien> findByNumber(@PathVariable("number") Integer number) throws HotelException {
        Entretien entretien = iEntretien.searchEntretienByNumero(number);
        return ResponseEntity.ok(entretien);
    }

    @DeleteMapping("/deleteentretien/{number}")
    public ResponseEntity<Void> delete(@PathVariable("number") Integer number) throws HotelException {
        iEntretien.deleteByNumber(number);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/deleteentretien")
    public ResponseEntity<Void> update(@RequestBody EntretienDto entretienDto) throws HotelException {
        iEntretien.update(entretienDto);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/allentretien")
    public ResponseEntity<List<EntretienDto>> listeentretien() {
        return ResponseEntity.ok(iEntretien.listentretien());
    }
}