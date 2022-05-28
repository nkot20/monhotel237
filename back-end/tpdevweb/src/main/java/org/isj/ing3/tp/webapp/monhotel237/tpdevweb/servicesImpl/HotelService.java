package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Hotel;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.HotelMapper;
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
public class HotelService {

    @Autowired
    private HotelRepository repository;
    @Autowired
    private HotelMapper hotelMapper;

    public HotelDto save(HotelDto hotelDto) {
        return hotelMapper.toDto(repository.save(hotelMapper.toEntity(hotelDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public HotelDto findById(Integer id) throws HotelException {
        return hotelMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    public HotelDto update(HotelDto hotelDto, Integer id) throws HotelException {
        HotelDto data = findById(id);
        Hotel entity = hotelMapper.toEntity(hotelDto);
        hotelMapper.copy(data, entity);
        return save(hotelMapper.toDto(entity));
    }
}