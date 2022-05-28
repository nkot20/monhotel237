package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ResourceNotFoundException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categoriechambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.CategoriechambreRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.CategoriechambreMapper;
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
public class CategoriechambreService {

    @Autowired
    private CategoriechambreRepository repository;
    @Autowired
    private CategoriechambreMapper categoriechambreMapper;


    public CategoriechambreDto save(CategoriechambreDto categoriechambreDto) {
        return categoriechambreMapper.toDto(repository.save(categoriechambreMapper.toEntity(categoriechambreDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public CategoriechambreDto findById(Integer id) throws HotelException {
        return categoriechambreMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    public CategoriechambreDto update(CategoriechambreDto categoriechambreDto) throws HotelException {
        CategoriechambreDto data = findById(categoriechambreDto.getId());
        Categoriechambre entity = categoriechambreMapper.toEntity(categoriechambreDto);
        categoriechambreMapper.copy(data, entity);
        return save(categoriechambreMapper.toDto(entity));
    }
}