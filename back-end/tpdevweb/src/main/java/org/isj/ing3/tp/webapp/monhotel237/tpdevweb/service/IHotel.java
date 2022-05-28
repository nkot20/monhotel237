package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;

public interface IHotel extends IEntity<HotelDto>{
    public HotelDto searchByEmail(String email);
}
