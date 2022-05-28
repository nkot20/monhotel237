package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EntretienMapper;
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
public class EntretienService {

    @Autowired
    private EntretienRepository repository;
    @Autowired
    private EntretienMapper entretienMapper;

    public EntretienDto save(EntretienDto entretienDto) {
        return entretienMapper.toDto(repository.save(entretienMapper.toEntity(entretienDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public EntretienDto findById(Integer id) throws HotelException {
        return entretienMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    public EntretienDto update(EntretienDto entretienDto) throws HotelException {
        EntretienDto data = findById(entretienDto.getId());
        Entretien entity = entretienMapper.toEntity(entretienDto);
        entretienMapper.copy(data, entity);
        return save(entretienMapper.toDto(entity));
    }
}