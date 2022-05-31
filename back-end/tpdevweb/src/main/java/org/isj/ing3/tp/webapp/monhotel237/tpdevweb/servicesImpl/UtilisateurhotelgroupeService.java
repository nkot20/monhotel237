package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.UtilisateurhotelgroupeMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IUtilisateurHotelGroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UtilisateurhotelgroupeService implements IUtilisateurHotelGroupe {

    @Autowired
    private UtilisateurhotelgroupeRepository utilisateurhotelgroupeRepository;
    @Autowired
    private UtilisateurhotelgroupeMapper utilisateurhotelgroupeMapper;

    @Override
    public UtilisateurhotelgroupeDto addData(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {

        CHeckNull.checkEmail(utilisateurhotelgroupeDto.getEmail());
        checkeEmailIsAlreadyUsed(utilisateurhotelgroupeDto.getEmail());
        return utilisateurhotelgroupeMapper.toDto(utilisateurhotelgroupeRepository.save(utilisateurhotelgroupeMapper.toEntity(utilisateurhotelgroupeDto)));
    }


    @Override
    public UtilisateurhotelgroupeDto searchById(Integer id) throws HotelException {
        return utilisateurhotelgroupeMapper.toDto(utilisateurhotelgroupeRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    @Override
    public Utilisateurhotelgroupe searchByEmail(String email) throws HotelException {
        CHeckNull.checkEmail(email);
        return utilisateurhotelgroupeRepository.findUtilisateurhotelgroupeByEmail(email).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public void deleteByEmail(String email) throws HotelException {
        Utilisateurhotelgroupe utilisateurhotelgroupe = searchByEmail(email);
        utilisateurhotelgroupeRepository.deleteById(utilisateurhotelgroupe.getId());
    }

    @Override
    public List<UtilisateurhotelgroupeDto> listUtilisateurhotelgroupeDto() {
        return null;
    }


    @Override
    public UtilisateurhotelgroupeDto update(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        Utilisateurhotelgroupe entity = searchByEmail(utilisateurhotelgroupeDto.getEmail());
        utilisateurhotelgroupeMapper.copy(utilisateurhotelgroupeDto, entity);
        return utilisateurhotelgroupeMapper.toDto(utilisateurhotelgroupeRepository.save(entity));
    }

    private void checkeEmailIsAlreadyUsed(String email) throws HotelException {
        if (utilisateurhotelgroupeRepository.findUtilisateurhotelgroupeByEmail(email).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }

    @Override
    public List<UtilisateurhotelgroupeDto> getAll() {
        return null;
    }

}