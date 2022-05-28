package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ChambreMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.ChambreRepository;
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
public class ChambreService {

    @Autowired
    private ChambreRepository repository;
    @Autowired
    private ChambreMapper chambreMapper;

    public ChambreDto save(ChambreDto chambreDto) {
        return chambreMapper.toDto(repository.save(chambreMapper.toEntity(chambreDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public ChambreDto findById(Integer id) throws HotelException {
        return chambreMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    public ChambreDto update(ChambreDto chambreDto) throws HotelException {
        ChambreDto data = findById(chambreDto.getId());
        Chambre entity = chambreMapper.toEntity(chambreDto);
        chambreMapper.copy(data, entity);
        return save(chambreMapper.toDto(entity));
    }
}