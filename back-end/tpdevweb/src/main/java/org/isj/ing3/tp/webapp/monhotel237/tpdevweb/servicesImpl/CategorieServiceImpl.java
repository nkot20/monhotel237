package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categorie;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.CategorieMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.CategorieRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class CategorieServiceImpl implements ICategorie {

    @Autowired
    private CategorieRepository repository;
    @Autowired
    private CategorieMapper categorieMapper;

    @Override
    public CategorieDto addData(CategorieDto categorieDto) {
        return categorieMapper.toDto(repository.save(categorieMapper.toEntity(categorieDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CategorieDto searchById(Integer id) throws HotelException {
        return categorieMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public CategorieDto update(CategorieDto categorieDto) throws HotelException {
        CategorieDto data = searchById(categorieDto.getId());
        Categorie entity = categorieMapper.toEntity(categorieDto);
        categorieMapper.copy(data, entity);
        return addData(categorieMapper.toDto(entity));
    }

    @Override
    public CategorieDto getAll() {
        return null;
    }
}