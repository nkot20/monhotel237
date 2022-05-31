package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EntretienDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Entretien;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.EntretienMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IEntretien;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class EntretienService implements IEntretien {

    @Autowired
    private EntretienRepository entretienRepository;
    @Autowired
    private EntretienMapper entretienMapper;

    @Override
    public EntretienDto addData(EntretienDto entretienDto) throws HotelException {
        //CHeckNull.checkNumero(entretienDto.getNumero());
        entretienDto.setNumero(generateUniqueNumber());
        entretienDto.setUser("nkot");
        checkNumberIsAlreadyUsed(entretienDto.getNumero());
        return entretienMapper.toDto(entretienRepository.save(entretienMapper.toEntity(entretienDto)));
    }

    @Override
    public EntretienDto searchById(Integer id) throws HotelException {
        return entretienMapper.toDto(entretienRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public Entretien searchEntretienByNumero(Integer numero) throws HotelException {
        CHeckNull.checkNumero(numero);
        return entretienRepository.findEntretienByNumero(numero).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public void deleteByNumber(Integer number) throws HotelException {
        Entretien entretien = searchEntretienByNumero(number);
        entretienRepository.deleteById(entretien.getId());
    }


    @Override
    public EntretienDto update(EntretienDto entretienDto) throws HotelException {
        Entretien entity = searchEntretienByNumero(entretienDto.getNumero());
        entretienMapper.copy(entretienDto, entity);
        return entretienMapper.toDto(entretienRepository.save(entity));
    }

    private void checkNumberIsAlreadyUsed(Integer number) throws HotelException {
        if (entretienRepository.findEntretienByNumero(number).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }

    @Override
    public List<EntretienDto> getAll() {
        return null;
    }
    @Override
    public List<EntretienDto> listentretien() {
        return entretienRepository.findAll().stream().map(entretien -> entretienMapper.toDto(entretien))
                .collect(Collectors.toList());
    }

    private int generateUniqueNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int random = (new Random()).nextInt(3000);
        return year + month + day + hour + random;
    }


}