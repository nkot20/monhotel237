package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.VilleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Employe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEmploye;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.EmployeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/employe")
@RestController
@Slf4j
@Api("employe")
public class EmployeRestController {

    @Autowired
    private IEmploye employeService;

    @PostMapping(value = "/saveemploye")
    public ResponseEntity<Void> save(@RequestBody EmployeDto employeDto) throws HotelException, JRException, FileNotFoundException {
        employeService.addData(employeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getemploye/{email}")
    public ResponseEntity<Employe> findByEmail(@PathVariable("email") String email) throws HotelException {
        Employe employe = employeService.searchByEmail(email);
        return ResponseEntity.ok(employe);
    }
    @GetMapping("/findemploye/{nom}")
    public ResponseEntity<Employe> findByNom(@PathVariable("nom") String nom) throws HotelException {
        Employe employe = employeService.searchByNom(nom);
        return ResponseEntity.ok(employe);
    }

    @DeleteMapping("/deleteemploye/{id}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email) throws HotelException {
        employeService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateemployee")
    public ResponseEntity<Void> update(@RequestBody EmployeDto employeDto) throws HotelException {
        employeService.update(employeDto);
        return ResponseEntity.ok().build();
    }


   /* private void getAuthentificationContext(Model model) {
    }*/

}