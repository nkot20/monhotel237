package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Employe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;

import java.util.List;

public interface IEmploye extends IEntity<EmployeDto>{
    public Employe searchByEmail(String email) throws HotelException;

    //Employe searchEmploye(List<Employe> employes);

    public Employe searchByName(String nom) throws HotelException;


    public void deleteByEmail(String email) throws HotelException;

    List<EmployeDto> listEmployes();


}
