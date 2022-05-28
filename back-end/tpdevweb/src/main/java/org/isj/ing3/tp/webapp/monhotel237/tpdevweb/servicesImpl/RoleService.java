package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Role;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.RoleMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class RoleService implements IRole {

    @Autowired
    private RoleRepository repository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDto addData(RoleDto roleDto) {
        return roleMapper.toDto(repository.save(roleMapper.toEntity(roleDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public RoleDto searchById(Integer id) throws HotelException {
        return roleMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public RoleDto update(RoleDto roleDto) throws HotelException {
        RoleDto data = searchById(roleDto.getId());
        Role entity = roleMapper.toEntity(roleDto);
        roleMapper.copy(data, entity);
        return addData(roleMapper.toDto(entity));
    }

    @Override
    public RoleDto getAll() {
        return null;
    }
}