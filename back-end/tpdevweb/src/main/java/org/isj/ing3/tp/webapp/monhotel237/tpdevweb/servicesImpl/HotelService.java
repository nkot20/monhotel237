package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Hotel;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.HotelMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IHotel;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class HotelService implements IHotel {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public HotelDto addData(HotelDto hotelDto) throws HotelException {
        CHeckNull.checkEmail(hotelDto.getEmail());
        checkEmailIsAlreadyUsed(hotelDto.getEmail());
        return hotelMapper.toDto(hotelRepository.save(hotelMapper.toEntity(hotelDto)));
    }


    @Override
    public HotelDto searchById(Integer id) throws HotelException {
        return hotelMapper.toDto(hotelRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public Hotel searchByEmail(String email) throws HotelException {
        CHeckNull.checkEmail(email);
        return hotelRepository.findHotelByEmail(email).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public void deleteByEmail(String email) throws HotelException {
        Hotel hotel = searchByEmail(email);
        hotelRepository.deleteById(hotel.getId());
    }

    @Override
    public HotelDto update(HotelDto hotelDto) throws HotelException {
        Hotel entity = searchByEmail(hotelDto.getEmail());
        hotelMapper.copy(hotelDto, entity);
        return hotelMapper.toDto(hotelRepository.save(entity));
    }

    @Override
    public List<HotelDto> getAll() {

            return hotelRepository.findAll().stream().map(hotel -> hotelMapper.toDto(hotel))
                    .collect(Collectors.toList());

    }

    private void checkEmailIsAlreadyUsed(String email) throws HotelException {
        if (hotelRepository.findHotelByEmail(email).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }
    @Override
    public List<HotelDto> searchhotelByKeyword(String keyword) {

        // return acteRepository.findActeByNumeroOrNom(keyword,keyword).get().stream().map(acte -> acteMapper.toDto(acte)).collect(Collectors.toList());
        return hotelRepository.findActeByNumeroOrNom(keyword,keyword).get().stream().map(hotelMapper::toDto).collect(Collectors.toList());
    }



}