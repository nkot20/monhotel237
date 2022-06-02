package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;

import java.io.FileNotFoundException;
import java.util.List;

public interface IEntity<D> {
    public D addData(D dto) throws HotelException, JRException, FileNotFoundException;

    public D searchById(Integer id) throws HotelException;

    public D update(D dto) throws HotelException;

    public List<D> getAll();
}
