package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Employe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EmployeMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class EmployeService {

    @Autowired
    private EmployeRepository repository;
    @Autowired
    private EmployeMapper employeMapper;

    public EmployeDto save(EmployeDto employeDto) {
        return employeMapper.toDto(repository.save(employeMapper.toEntity(employeDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public EmployeDto findById(Integer id) throws HotelException {
        return employeMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    public EmployeDto update(EmployeDto employeDto) throws HotelException {
        EmployeDto data = findById(employeDto.getId());
        Employe entity = employeMapper.toEntity(employeDto);
        employeMapper.copy(data, entity);
        return save(employeMapper.toDto(entity));
    }
}