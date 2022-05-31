package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.VilleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Ville;

import java.util.List;

public interface IVille extends IEntity<VilleDto>{
    Ville searchCityByName(String name) throws HotelException;

    public void deleteCityByName(String name) throws HotelException;
    List<VilleDto> listVilleDto();
}
