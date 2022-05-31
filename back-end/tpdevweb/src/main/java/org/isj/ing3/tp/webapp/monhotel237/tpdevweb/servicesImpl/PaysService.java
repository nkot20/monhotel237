package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.PaysDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Pays;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.PaysMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IPays;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class PaysService implements IPays {

    @Autowired
    private PaysRepository paysRepository;
    @Autowired
    private PaysMapper paysMapper;

    @Override
    public PaysDto addData(PaysDto paysDto) throws HotelException {
        CHeckNull.checkNomPays(paysDto.getNompays());
        checkNomPaysIsAlreadyUsed(paysDto.getNompays());
        return paysMapper.toDto(paysRepository.save(paysMapper.toEntity(paysDto)));
    }

    @Override
    public PaysDto searchById(Integer id) throws HotelException {
        return paysMapper.toDto(paysRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public Pays searchPaysByNompays(String nompays) throws HotelException {
        CHeckNull.checkNomPays(nompays);
        return paysRepository.findByNompays(nompays).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public void deletePaysByNomPays(String nompays) throws HotelException {
        Pays pays = searchPaysByNompays(nompays);
        paysRepository.deleteById(pays.getId());
    }

    @Override
    public PaysDto update(PaysDto paysDto) throws HotelException {
        Pays entity = searchPaysByNompays(paysDto.getNompays());
        paysMapper.copy(paysDto, entity);
        return paysMapper.toDto(paysRepository.save(entity));
    }

    @Override
    public List<PaysDto> getAll() {
        return null;
    }

    private void checkNomPaysIsAlreadyUsed(String nomPays) throws HotelException {
        if (paysRepository.findByNompays(nomPays).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }



}