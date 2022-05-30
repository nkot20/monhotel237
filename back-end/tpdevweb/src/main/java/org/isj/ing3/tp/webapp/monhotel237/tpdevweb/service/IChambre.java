package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;

import java.util.List;

public interface IChambre extends IEntity<ChambreDto>{
    Chambre searchChambreByNumber(Integer number) throws HotelException;

    List<ChambreDto> listChambres();

    ChambreDto searchChambreByNumberDto(Integer number) throws HotelException;

    public void deleteByNumber(Integer number) throws HotelException;

   // List<ChambreDto> searchChambresByKeyword(String keyword);
}
