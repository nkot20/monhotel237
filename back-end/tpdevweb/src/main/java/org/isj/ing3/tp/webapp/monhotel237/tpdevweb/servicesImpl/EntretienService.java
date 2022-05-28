package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EntretienMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEntretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class EntretienService implements IEntretien {

    @Autowired
    private EntretienRepository repository;
    @Autowired
    private EntretienMapper entretienMapper;

    @Override
    public EntretienDto addData(EntretienDto entretienDto) {
        return entretienMapper.toDto(repository.save(entretienMapper.toEntity(entretienDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public EntretienDto searchById(Integer id) throws HotelException {
        return entretienMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    @Override
    public EntretienDto update(EntretienDto entretienDto) throws HotelException {
        EntretienDto data = searchById(entretienDto.getId());
        Entretien entity = entretienMapper.toEntity(entretienDto);
        entretienMapper.copy(data, entity);
        return addData(entretienMapper.toDto(entity));
    }

    @Override
    public EntretienDto getAll() {
        return null;
    }
}