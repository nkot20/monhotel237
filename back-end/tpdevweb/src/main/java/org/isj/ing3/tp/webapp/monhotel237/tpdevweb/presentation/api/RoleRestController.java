package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Role;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IRole;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/role")
@RestController
@Slf4j
@Api("role")
public class RoleRestController {

    @Autowired
    private IRole iRole;

    @PostMapping("/saverole")
    public ResponseEntity<Void> save(@RequestBody RoleDto roleDto) throws HotelException, JRException, FileNotFoundException {
        iRole.addData(roleDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getrole/{intitule}")
    public ResponseEntity<Role> findByIntitule(@PathVariable("intitule") String intitule) throws HotelException {
        Role role = iRole.searchRoleByIntitule(intitule);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/deleterole/{intitule}")
    public ResponseEntity<Void> delete(@PathVariable("intitule") String intitule) throws HotelException {
        Optional.ofNullable(iRole.searchRoleByIntitule(intitule));
        iRole.deleteRoleByIntitule(intitule);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updaterole")
    public ResponseEntity<Void> update(@RequestBody RoleDto roleDto) throws HotelException {
        iRole.update(roleDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/allrole")
    public ResponseEntity<List<RoleDto>> listeRole() {
        return ResponseEntity.ok(iRole.listRoles());
    }
}