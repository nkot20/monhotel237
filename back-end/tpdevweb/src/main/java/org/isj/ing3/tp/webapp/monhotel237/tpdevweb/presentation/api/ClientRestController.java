package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/client")
@RestController
@Slf4j
@Api("client")
public class ClientRestController {
    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/savecustomer")
    public ResponseEntity<Void> save(@RequestBody @Validated ClientDto clientDto) throws HotelException {
        clientService.addData(clientDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchcustomer/{email}")
    public ResponseEntity<ClientDto> findByEmail(@PathVariable("email") String email) throws HotelException {
        ClientDto client = clientService.searchByEmailDto(email);
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
}