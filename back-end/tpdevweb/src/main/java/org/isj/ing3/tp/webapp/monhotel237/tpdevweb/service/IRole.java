package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.RoleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Role;

import java.util.List;

public interface IRole extends IEntity<RoleDto>{

    public Role searchRoleByIntitule(String intitule) throws HotelException;

    public void deleteRoleByIntitule(String intitule) throws HotelException;
    public List<RoleDto> listRoles();

}
