package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;

import java.util.List;

public interface IUtilisateurHotelGroupe extends IEntity<UtilisateurhotelgroupeDto>{

    public Utilisateurhotelgroupe searchByEmail(String email) throws HotelException;

    public String deleteByEmail(String email) throws HotelException;
    List<UtilisateurhotelgroupeDto> listUtilisateurhotelgroupeDto();

}
