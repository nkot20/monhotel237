package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.VilleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Ville;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.VilleMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IVille;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class VilleService implements IVille {

    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private VilleMapper villeMapper;

    @Override
    public VilleDto addData(VilleDto villeDto) throws HotelException {
        CHeckNull.checkNomVille(villeDto.getNomville());
        checkNomVilleIsAlreadyUsed(villeDto.getNomville());
        return villeMapper.toDto(villeRepository.save(villeMapper.toEntity(villeDto)));
    }

    @Override
    public VilleDto searchById(Integer id) throws HotelException {
        return villeMapper.toDto(villeRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public Ville searchCityByName(String name) throws HotelException {
        CHeckNull.checkNomVille(name);
        return villeRepository.findVilleByNomville(name).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public void deleteCityByName(String name) throws HotelException {
        Ville ville = searchCityByName(name);
        villeRepository.deleteById(ville.getId());
    }

    @Override
    public VilleDto update(VilleDto villeDto) throws HotelException {
        Ville entity = searchCityByName(villeDto.getNomville());
        villeMapper.copy(villeDto, entity);
        return villeMapper.toDto(villeRepository.save(entity));
    }

    private void checkNomVilleIsAlreadyUsed(String nomville) throws HotelException {
        if (villeRepository.findVilleByNomville(nomville).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }

    @Override
    public List<VilleDto> getAll() {
        return null;
    }


}