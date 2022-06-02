package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Client;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/client")
@RestController
@Slf4j
@Api("client")
public class ClientRestController {
    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/savecustomer")
    public ResponseEntity<Void> save(@RequestBody @Validated ClientDto clientDto) throws HotelException, JRException, FileNotFoundException {
        clientService.addData(clientDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchcustomer/{email}")
    public ResponseEntity<ClientDto> findByEmail(@PathVariable("email") String email) throws HotelException {
        ClientDto client = clientService.searchByEmailDto(email);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/findcustomer/{nom}")
    public ResponseEntity<Client> findByNom(@PathVariable("nom") String nom) throws HotelException {
        Client client = clientService.searchByNom(nom);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/deletecustomer/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email) throws HotelException {
        clientService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatecustomer")
    public ResponseEntity<Void> update(@RequestBody ClientDto clientDto) throws HotelException {
        clientService.update(clientDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> listClients() {
        return ResponseEntity.ok(clientService.listClients());
    }



}