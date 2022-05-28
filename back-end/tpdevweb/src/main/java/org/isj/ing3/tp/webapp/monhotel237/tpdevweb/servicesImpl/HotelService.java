package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Hotel;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.HotelMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class HotelService implements IHotel {

    @Autowired
    private HotelRepository repository;
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public HotelDto addData(HotelDto hotelDto) {
        return hotelMapper.toDto(repository.save(hotelMapper.toEntity(hotelDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public HotelDto searchById(Integer id) throws HotelException {
        return hotelMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public HotelDto update(HotelDto hotelDto) throws HotelException {
        HotelDto data = searchById(hotelDto.getId());
        Hotel entity = hotelMapper.toEntity(hotelDto);
        hotelMapper.copy(data, entity);
        return addData(hotelMapper.toDto(entity));
    }

    @Override
    public HotelDto getAll() {
        return null;
    }

    @Override
    public HotelDto searchByEmail(String email) {
        return null;
    }
}