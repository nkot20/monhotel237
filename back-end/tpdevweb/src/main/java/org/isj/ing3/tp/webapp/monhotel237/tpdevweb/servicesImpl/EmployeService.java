package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Employe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EmployeMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class EmployeService implements IEmploye {

    @Autowired
    private EmployeRepository repository;
    @Autowired
    private EmployeMapper employeMapper;

    @Override
    public EmployeDto addData(EmployeDto employeDto) {
        return employeMapper.toDto(repository.save(employeMapper.toEntity(employeDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeDto searchById(Integer id) throws HotelException {
        return employeMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public EmployeDto update(EmployeDto employeDto) throws HotelException {
        EmployeDto data = searchById(employeDto.getId());
        Employe entity = employeMapper.toEntity(employeDto);
        employeMapper.copy(data, entity);
        return addData(employeMapper.toDto(entity));
    }

    @Override
    public EmployeDto getAll() {
        return null;
    }

    @Override
    public Employe searchByEmail(String email) {
        return null;
    }
}