package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ReservationDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;

import java.util.List;

public interface IReservation extends IEntity<ReservationDto>{
    public Entretien searchReservationByNumero(Integer numero) throws HotelException;

    public void deleteByNumber(Integer number) throws HotelException;
    public List<ReservationDto> listreservation();
}
