package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categorie;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.CategorieMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.CategorieRepository;
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
public class CategorieService {

    @Autowired
    private CategorieRepository repository;
    @Autowired
    private CategorieMapper categorieMapper;

    public CategorieDto save(CategorieDto categorieDto) {
        return categorieMapper.toDto(repository.save(categorieMapper.toEntity(categorieDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public CategorieDto findById(Integer id) throws HotelException {
        return categorieMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    public CategorieDto update(CategorieDto categorieDto) throws HotelException {
        CategorieDto data = findById(categorieDto.getId());
        Categorie entity = categorieMapper.toEntity(categorieDto);
        categorieMapper.copy(data, entity);
        return save(categorieMapper.toDto(entity));
    }
}