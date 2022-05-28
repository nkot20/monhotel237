package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.UtilisateurhotelgroupeMapper;
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
public class UtilisateurhotelgroupeService {

    @Autowired
    private UtilisateurhotelgroupeRepository repository;
    @Autowired
    private UtilisateurhotelgroupeMapper utilisateurhotelgroupeMapper;

    public UtilisateurhotelgroupeDto save(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) {
        return utilisateurhotelgroupeMapper.toDto(repository.save(utilisateurhotelgroupeMapper.toEntity(utilisateurhotelgroupeDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public UtilisateurhotelgroupeDto findById(Integer id) throws HotelException {
        return utilisateurhotelgroupeMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    public UtilisateurhotelgroupeDto update(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        UtilisateurhotelgroupeDto data = findById(utilisateurhotelgroupeDto.getId());
        Utilisateurhotelgroupe entity = utilisateurhotelgroupeMapper.toEntity(utilisateurhotelgroupeDto);
        utilisateurhotelgroupeMapper.copy(data, entity);
        return save(utilisateurhotelgroupeMapper.toDto(entity));
    }
}