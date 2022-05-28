package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.UtilisateurhotelgroupeMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IUtilisateurHotelGroupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class UtilisateurhotelgroupeService implements IUtilisateurHotelGroupe {

    @Autowired
    private UtilisateurhotelgroupeRepository repository;
    @Autowired
    private UtilisateurhotelgroupeMapper utilisateurhotelgroupeMapper;

    @Override
    public UtilisateurhotelgroupeDto addData(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) {
        return utilisateurhotelgroupeMapper.toDto(repository.save(utilisateurhotelgroupeMapper.toEntity(utilisateurhotelgroupeDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public UtilisateurhotelgroupeDto searchById(Integer id) throws HotelException {
        return utilisateurhotelgroupeMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    @Override
    public UtilisateurhotelgroupeDto update(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        UtilisateurhotelgroupeDto data = searchById(utilisateurhotelgroupeDto.getId());
        Utilisateurhotelgroupe entity = utilisateurhotelgroupeMapper.toEntity(utilisateurhotelgroupeDto);
        utilisateurhotelgroupeMapper.copy(data, entity);
        return addData(utilisateurhotelgroupeMapper.toDto(entity));
    }

    @Override
    public UtilisateurhotelgroupeDto getAll() {
        return null;
    }

    @Override
    public Utilisateurhotelgroupe searchByEmail(String email) {
        return null;
    }
}