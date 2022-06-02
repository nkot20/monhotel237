package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Client;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;

import java.util.List;

public interface IClient extends IEntity<ClientDto>{
    public Client searchByEmail(String email) throws HotelException;

    public Client searchByNom(String nom) throws HotelException;

    public ClientDto searchByEmailDto(String email) throws HotelException;

    //public ClientDto searchByNomOrEmail(String nom, String email) throws HotelException;

    public int deleteByEmail(String email) throws HotelException;

    List<ClientDto> listClients();

    public ClientDto searchByNomDto(String nom) throws HotelException;
}
