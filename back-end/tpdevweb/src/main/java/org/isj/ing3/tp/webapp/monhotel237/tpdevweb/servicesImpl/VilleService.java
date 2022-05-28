package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.VilleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Ville;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.VilleMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IVille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class VilleService implements IVille {

    @Autowired
    private VilleRepository repository;
    @Autowired
    private VilleMapper villeMapper;

    @Override
    public VilleDto addData(VilleDto villeDto) {
        return villeMapper.toDto(repository.save(villeMapper.toEntity(villeDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public VilleDto searchById(Integer id) throws HotelException {
        return villeMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public VilleDto update(VilleDto villeDto) throws HotelException {
        VilleDto data = searchById(villeDto.getId());
        Ville entity = villeMapper.toEntity(villeDto);
        villeMapper.copy(data, entity);
        return addData(villeMapper.toDto(entity));
    }

    @Override
    public VilleDto getAll() {
        return null;
    }
}