package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Role;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.RoleMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository repository;
    @Autowired
    private RoleMapper roleMapper;

    public RoleDto save(RoleDto roleDto) {
        return roleMapper.toDto(repository.save(roleMapper.toEntity(roleDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public RoleDto findById(Integer id) throws HotelException {
        return roleMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    public RoleDto update(RoleDto roleDto) throws HotelException {
        RoleDto data = findById(roleDto.getId());
        Role entity = roleMapper.toEntity(roleDto);
        roleMapper.copy(data, entity);
        return save(roleMapper.toDto(entity));
    }
}