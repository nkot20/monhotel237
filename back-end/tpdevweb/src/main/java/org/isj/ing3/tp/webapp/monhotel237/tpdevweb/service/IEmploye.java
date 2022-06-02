package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Employe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;

import java.util.List;

public interface IEmploye extends IEntity<EmployeDto>{

    int saveEmploye(EmployeDto employeDto) throws HotelException;
    public Employe searchByEmail(String email) throws HotelException;

    public EmployeDto searchByNomDto(String nom) throws HotelException;

    public Employe searchByNom(String nom) throws HotelException;

    EmployeDto updateEmployeDto(EmployeDto employeDto) throws HotelException;

    public int deleteByEmail(String email) throws HotelException;

    public int deleteByNom(String nom) throws HotelException;

    List<EmployeDto> listEmployes();


}
