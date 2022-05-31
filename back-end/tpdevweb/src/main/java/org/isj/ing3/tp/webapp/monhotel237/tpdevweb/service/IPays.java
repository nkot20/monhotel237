package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.PaysDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Pays;

import java.util.List;

public interface IPays extends IEntity<PaysDto>{

    public Pays searchPaysByNompays(String nompays) throws HotelException;

    public void deletePaysByNomPays(String nompays) throws HotelException;

    List<PaysDto> listPays();

}
