package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categoriechambre;

import java.util.List;

public interface ICategorieChambre extends IEntity<CategoriechambreDto>{
    Categoriechambre searchCategoriechambreByLibelle(String libelle) throws HotelException;

    List<CategoriechambreDto> listCategoriechambres();

    CategoriechambreDto searchCategoriechambreByLibelle2(String libelle) throws HotelException;

    public void deleteByLibelle(String libelle) throws HotelException;
}
