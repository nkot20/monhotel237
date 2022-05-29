package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;

public interface IChambre extends IEntity<ChambreDto>{
    Chambre searchChambreByNumber(Integer number) throws HotelException;

    ChambreDto searchChambreByNumberDto(Integer number) throws HotelException;

    public void deleteByNumber(Integer number) throws HotelException;
}
