package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Hotel;

import java.util.List;
import java.util.Set;

public interface IHotel extends IEntity<HotelDto>{
    public Hotel searchByEmail(String email) throws HotelException;

    public void deleteByEmail(String email) throws HotelException;
    public List<HotelDto> Listhotel();

}
