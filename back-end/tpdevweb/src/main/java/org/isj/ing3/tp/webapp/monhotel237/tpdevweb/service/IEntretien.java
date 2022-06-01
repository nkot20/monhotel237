package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;

import java.util.List;

public interface IEntretien extends IEntity<EntretienDto>{

    public Entretien searchEntretienByNumero(Integer numero) throws HotelException;

    public void deleteByNumber(Integer number) throws HotelException;
    public List<EntretienDto> listentretien();

    EntretienDto searchEntretienByNumeroDto(Integer numero) throws HotelException;

    List<EntretienDto> searchEntretienByRoom(Integer numero) throws HotelException;

}
