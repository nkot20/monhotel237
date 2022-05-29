package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Role;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.RoleMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IRole;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class RoleService implements IRole {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDto addData(RoleDto roleDto) throws HotelException {
        CHeckNull.checkIntitule(roleDto.getIntitule());
        checkIntituleIsAlreadyUsed(roleDto.getIntitule());
        return roleMapper.toDto(roleRepository.save(roleMapper.toEntity(roleDto)));
    }

    @Override
    public Role searchRoleByIntitule(String intitule) throws HotelException {
        CHeckNull.checkIntitule(intitule);
        return roleRepository.findRoleByIntitule(intitule).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public void deleteRoleByIntitule(String intitule) throws HotelException {
        Role role = searchRoleByIntitule(intitule);
        roleRepository.deleteById(role.getId());
    }

    @Override
    public RoleDto searchById(Integer id) throws HotelException {
        return roleMapper.toDto(roleRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public RoleDto update(RoleDto roleDto) throws HotelException {
        Role entity = searchRoleByIntitule(roleDto.getIntitule());
        roleMapper.copy(roleDto, entity);
        return roleMapper.toDto(roleRepository.save(entity));
    }

    @Override
    public RoleDto getAll() {
        return null;
    }

    private void checkIntituleIsAlreadyUsed(String intitule) throws HotelException {
        if (roleRepository.findRoleByIntitule(intitule).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }
}