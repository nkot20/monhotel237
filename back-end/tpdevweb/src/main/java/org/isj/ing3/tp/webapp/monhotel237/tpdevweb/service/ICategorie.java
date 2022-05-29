package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categorie;

public interface ICategorie extends IEntity<CategorieDto>{
    Categorie searchCategorieByIntitule(String intitule) throws HotelException;

    CategorieDto searchCategorieByIntitule2(String intitule) throws HotelException;

    public void deleteByIntitule(String intitule) throws HotelException;
}
