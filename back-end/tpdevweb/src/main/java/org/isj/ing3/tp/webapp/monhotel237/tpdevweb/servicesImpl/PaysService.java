package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.PaysDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Pays;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.PaysMapper;
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
public class PaysService {

    @Autowired
    private PaysRepository repository;
    @Autowired
    private PaysMapper paysMapper;

    public PaysDto save(PaysDto paysDto) {
        return paysMapper.toDto(repository.save(paysMapper.toEntity(paysDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public PaysDto findById(Integer id) throws HotelException {
        return paysMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    public PaysDto update(PaysDto paysDto) throws HotelException {
        PaysDto data = findById(paysDto.getId());
        Pays entity = paysMapper.toEntity(paysDto);
        paysMapper.copy(data, entity);
        return save(paysMapper.toDto(entity));
    }
}