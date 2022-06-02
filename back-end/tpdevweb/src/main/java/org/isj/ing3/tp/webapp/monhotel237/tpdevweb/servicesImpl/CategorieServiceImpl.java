package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categorie;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.CategorieMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.CategorieRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorie;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class CategorieServiceImpl implements ICategorie {

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private CategorieMapper categorieMapper;

    @Override
    public CategorieDto addData(CategorieDto categorieDto) throws HotelException {
        CHeckNull.checkIntitule(categorieDto.getIntitule());
        checkIntituleIsAlreadyUsed(categorieDto.getIntitule());
        System.out.println(categorieDto);
        return categorieMapper.toDto(categorieRepository.save(categorieMapper.toEntity(categorieDto)));
    }

    @Override
    public CategorieDto searchById(Integer id) throws HotelException {
        return categorieMapper.toDto(categorieRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public Categorie searchCategorieByIntitule(String intitule) throws HotelException {
        CHeckNull.checkIntitule(intitule);
        return categorieRepository.findCategorieByIntitule(intitule).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public CategorieDto searchCategorieByIntitule2(String intitule) throws HotelException {
        CHeckNull.checkIntitule(intitule);
        return categorieMapper.toDto(categorieRepository.findCategorieByIntitule(intitule).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public void deleteByIntitule(String intitule) throws HotelException {
        Categorie categorie = searchCategorieByIntitule(intitule);
        categorieRepository.deleteById(categorie.getId());
    }

    @Override
    public CategorieDto update(CategorieDto categorieDto) throws HotelException {
        Categorie entity = searchCategorieByIntitule(categorieDto.getIntitule());
        categorieMapper.copy(categorieDto, entity);
        return categorieMapper.toDto(categorieRepository.save(entity));
    }

    private void checkIntituleIsAlreadyUsed(String intitule) throws HotelException {
        if (categorieRepository.findCategorieByIntitule(intitule).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }

    @Override
    public List<CategorieDto> getAll() {
        return null;
    }

    @Override
    public List<CategorieDto> listCategories() {

        return categorieRepository.findAll().stream().map(categorie -> categorieMapper.toDto(categorie))
                .collect(Collectors.toList());
    }


}