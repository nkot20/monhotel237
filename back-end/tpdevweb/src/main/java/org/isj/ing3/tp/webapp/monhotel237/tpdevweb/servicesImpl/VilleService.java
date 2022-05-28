package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.VilleDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Ville;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.VilleMapper;
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
public class VilleService {

    @Autowired
    private VilleRepository repository;
    @Autowired
    private VilleMapper villeMapper;

    public VilleDto save(VilleDto villeDto) {
        return villeMapper.toDto(repository.save(villeMapper.toEntity(villeDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public VilleDto findById(Integer id) throws HotelException {
        return villeMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    public VilleDto update(VilleDto villeDto) throws HotelException {
        VilleDto data = findById(villeDto.getId());
        Ville entity = villeMapper.toEntity(villeDto);
        villeMapper.copy(data, entity);
        return save(villeMapper.toDto(entity));
    }
}