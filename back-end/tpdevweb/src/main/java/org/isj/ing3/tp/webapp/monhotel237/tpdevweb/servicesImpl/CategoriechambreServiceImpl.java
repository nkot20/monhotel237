package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;


import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategoriechambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categoriechambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.CategoriechambreRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.CategoriechambreMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.ICategorieChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class CategoriechambreServiceImpl implements ICategorieChambre {

    @Autowired
    private CategoriechambreRepository categoriechambreRepository;
    @Autowired
    private CategoriechambreMapper categoriechambreMapper;

    @Override
    public CategoriechambreDto addData(CategoriechambreDto categoriechambreDto) throws HotelException {
        CHeckNull.checkLibelle(categoriechambreDto.getLibelle());
        checkLibelleIsAlreadyUsed(categoriechambreDto.getLibelle());
        categoriechambreDto.setUsername("Pami Kelly");
        System.out.println(categoriechambreDto);
        return categoriechambreMapper.toDto(categoriechambreRepository.save(categoriechambreMapper.toEntity(categoriechambreDto)));
    }


    @Override
    public CategoriechambreDto searchById(Integer id) throws HotelException {
        return categoriechambreMapper.toDto(categoriechambreRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public Categoriechambre searchCategoriechambreByLibelle(String libelle) throws HotelException {
        CHeckNull.checkLibelle(libelle);
        return categoriechambreRepository.findCategoriechambreByLibelle(libelle).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    public CategoriechambreDto searchCategoriechambreByLibelle2(String libelle) throws HotelException {
        CHeckNull.checkLibelle(libelle);
        return categoriechambreMapper.toDto(categoriechambreRepository.findCategoriechambreByLibelle(libelle).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public void deleteByLibelle(String libelle) throws HotelException {
        Categoriechambre categoriechambre = searchCategoriechambreByLibelle(libelle);
        categoriechambreRepository.deleteById(categoriechambre.getId());
    }

    @Override
    public CategoriechambreDto update(CategoriechambreDto categoriechambreDto) throws HotelException {
        Categoriechambre entity = searchCategoriechambreByLibelle(categoriechambreDto.getLibelle());
        categoriechambreMapper.copy(categoriechambreDto, entity);
        return categoriechambreMapper.toDto(categoriechambreRepository.save(entity));
    }

    private void checkLibelleIsAlreadyUsed(String libelle) throws HotelException {
        if (categoriechambreRepository.findCategoriechambreByLibelle(libelle).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }

    @Override
    public List<CategoriechambreDto> getAll() {
        return null;
    }

    @Override
    public List<CategoriechambreDto> listCategoriechambres() {

        return categoriechambreRepository.findAll().stream().map(categoriechambre -> categoriechambreMapper.toDto(categoriechambre))
                .collect(Collectors.toList());
    }

}