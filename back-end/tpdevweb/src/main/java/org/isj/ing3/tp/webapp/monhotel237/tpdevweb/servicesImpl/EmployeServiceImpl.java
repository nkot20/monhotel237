package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Employe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EmployeMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEmploye;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class EmployeServiceImpl implements IEmploye {

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private EmployeMapper employeMapper;

    @Override
    public EmployeDto addData(EmployeDto employeDto) throws HotelException {
        CHeckNull.checkEmail(employeDto.getEmail());
        checkEmailIsAlreadyUsed(employeDto.getEmail());
        return employeMapper.toDto(employeRepository.save(employeMapper.toEntity(employeDto)));
    }

    @Override
    public EmployeDto searchById(Integer id) throws HotelException {
        return employeMapper.toDto(employeRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public EmployeDto searchByNomDto(String nom) throws HotelException{
        CHeckNull.checkNomEmploye(nom);
        return employeMapper.toDto(employeRepository.findEmployeByNom(nom)
                .orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public int saveEmploye(EmployeDto employeDto) {
        employeDto.setUser("nkot");
        if ( employeRepository.findEmployeByNom(employeDto.getNom()).isPresent() ) return 0;
        return employeRepository.save(employeMapper.toEntity(employeDto)).getId();
    }

    @Override
    public Employe searchByEmail(String email) throws HotelException {
        CHeckNull.checkEmail(email);
        return employeRepository.findEmployeByEmail(email).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }
    @Override
    public Employe searchByNom(String nom) throws HotelException {
        CHeckNull.checkNomEmploye(nom);
        return employeRepository.findEmployeByNom(nom)
                .orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public EmployeDto updateEmployeDto(EmployeDto employeDto) throws HotelException {
        Employe employe  = searchByNom(employeDto.getNom());
        employeMapper.copy(employeDto, employe);
        return employeMapper.toDto(employeRepository.save(employe));
    }

    @Override
    public int deleteByEmail(String email) throws HotelException {
        Employe employe = searchByEmail(email);
        employeRepository.deleteById(employe.getId());
        return 1;
    }

    @Override
    public int deleteByNom(String nom) throws HotelException {
        employeRepository.deleteById(employeRepository.findEmployeByNom(nom).get().getId());
        return 1;
    }

    @Override
    public EmployeDto update(EmployeDto employeDto) throws HotelException {
        Employe employe = searchByEmail(employeDto.getEmail());
        employeMapper.copy(employeDto, employe);
        return employeMapper.toDto(employeRepository.save(employe));
    }

    @Override
    public List<EmployeDto> getAll() {
        return employeRepository.findAll().stream().map(employe -> employeMapper.toDto(employe))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeDto> listEmployes() {
        return employeRepository.findAll().stream().map(employe -> employeMapper.toDto(employe))
                .collect(Collectors.toList());
    }

    private void checkEmailIsAlreadyUsed(String email) throws HotelException {
        if (employeRepository.findEmployeByEmail(email).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }


}