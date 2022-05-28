package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.PaysDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Pays;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.PaysMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IPays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class PaysService implements IPays {

    @Autowired
    private PaysRepository repository;
    @Autowired
    private PaysMapper paysMapper;

    @Override
    public PaysDto addData(PaysDto paysDto) {
        return paysMapper.toDto(repository.save(paysMapper.toEntity(paysDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public PaysDto searchById(Integer id) throws HotelException {
        return paysMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    @Override
    public PaysDto update(PaysDto paysDto) throws HotelException {
        PaysDto data = searchById(paysDto.getId());
        Pays entity = paysMapper.toEntity(paysDto);
        paysMapper.copy(data, entity);
        return addData(paysMapper.toDto(entity));
    }

    @Override
    public PaysDto getAll() {
        return null;
    }
}