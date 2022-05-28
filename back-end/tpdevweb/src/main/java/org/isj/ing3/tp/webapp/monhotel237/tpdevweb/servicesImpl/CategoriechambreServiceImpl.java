package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categoriechambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.CategoriechambreRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.CategoriechambreMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorieChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class CategoriechambreServiceImpl implements ICategorieChambre {

    @Autowired
    private CategoriechambreRepository repository;
    @Autowired
    private CategoriechambreMapper categoriechambreMapper;

    @Override
    public CategoriechambreDto addData(CategoriechambreDto categoriechambreDto) {
        return categoriechambreMapper.toDto(repository.save(categoriechambreMapper.toEntity(categoriechambreDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CategoriechambreDto searchById(Integer id) throws HotelException {
        return categoriechambreMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public CategoriechambreDto update(CategoriechambreDto categoriechambreDto) throws HotelException {
        CategoriechambreDto data = searchById(categoriechambreDto.getId());
        Categoriechambre entity = categoriechambreMapper.toEntity(categoriechambreDto);
        categoriechambreMapper.copy(data, entity);
        return addData(categoriechambreMapper.toDto(entity));
    }

    @Override
    public CategoriechambreDto getAll() {
        return null;
    }
}