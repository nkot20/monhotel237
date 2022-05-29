package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Client;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;

public interface IClient extends IEntity<ClientDto>{
    public Client searchByEmail(String email) throws HotelException;

    public ClientDto searchByEmailDto(String email) throws HotelException;

    public void deleteByEmail(String email) throws HotelException;
}
