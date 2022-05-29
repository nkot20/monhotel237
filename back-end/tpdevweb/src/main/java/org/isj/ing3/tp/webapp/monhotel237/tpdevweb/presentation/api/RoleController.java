package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Role;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/role")
@RestController
@Slf4j
@Api("role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @SneakyThrows
    @PostMapping("/saverole")
    public ResponseEntity<Void> save(@RequestBody RoleDto roleDto) {
        roleService.addData(roleDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getrole/{intitule}")
    public ResponseEntity<Role> findByIntitule(@PathVariable("intitule") String intitule) throws HotelException {
        Role role = roleService.searchRoleByIntitule(intitule);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/deleterole/{intitule}")
    public ResponseEntity<Void> delete(@PathVariable("intitule") String intitule) throws HotelException {
        Optional.ofNullable(roleService.searchRoleByIntitule(intitule));
        roleService.deleteRoleByIntitule(intitule);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updaterole")
    public ResponseEntity<Void> update(@RequestBody RoleDto roleDto) throws HotelException {
        roleService.update(roleDto);
        return ResponseEntity.ok().build();
    }
}