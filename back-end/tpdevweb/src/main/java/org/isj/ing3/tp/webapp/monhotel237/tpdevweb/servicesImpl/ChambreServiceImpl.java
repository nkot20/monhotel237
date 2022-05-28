package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ChambreMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.ChambreRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class ChambreServiceImpl implements IChambre {

    @Autowired
    private ChambreRepository repository;
    @Autowired
    private ChambreMapper chambreMapper;

    @Override
    public ChambreDto addData(ChambreDto chambreDto) {
        return chambreMapper.toDto(repository.save(chambreMapper.toEntity(chambreDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ChambreDto searchById(Integer id) throws HotelException {
        return chambreMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public ChambreDto update(ChambreDto chambreDto) throws HotelException {
        ChambreDto data = searchById(chambreDto.getId());
        Chambre entity = chambreMapper.toEntity(chambreDto);
        chambreMapper.copy(data, entity);
        return addData(chambreMapper.toDto(entity));
    }

    @Override
    public ChambreDto getAll() {
        return null;
    }
}