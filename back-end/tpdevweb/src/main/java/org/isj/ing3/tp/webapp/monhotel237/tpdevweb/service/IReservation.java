package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ReservationDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.FactureReservation;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

public interface IReservation extends IEntity<ReservationDto>{
    public Entretien searchReservationByNumero(Integer numero) throws HotelException;

    public void deleteByNumber(Integer number) throws HotelException;
    public List<ReservationDto> listreservation();
    public List<ChambreDto> listeChambreDispos(Date datebebut, Date datefin) throws HotelException;
    public byte[] generatedPdf(FactureReservation reservation) throws FileNotFoundException, JRException;
    public byte[] getBytes();
}
