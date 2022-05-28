package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;

public interface IEntity<D> {
    public D addData(D dto);

    public D searchById(Integer id) throws HotelException;

    public void deleteById(Integer id);

    public D update(D dto) throws HotelException;

    public D getAll();
}
