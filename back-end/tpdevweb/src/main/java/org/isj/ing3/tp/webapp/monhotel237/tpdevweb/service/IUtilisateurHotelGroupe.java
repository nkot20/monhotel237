package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;

public interface IUtilisateurHotelGroupe extends IEntity<UtilisateurhotelgroupeDto>{

    public Utilisateurhotelgroupe searchByEmail(String email) throws HotelException;

    public void deleteByEmail(String email) throws HotelException;

}
