package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.UtilisateurhotelgroupeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Role;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.UtilisateurhotelgroupeMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.*;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IUtilisateurHotelGroupe;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class UtilisateurhotelgroupeService implements IUtilisateurHotelGroupe {

    @Autowired
    private UtilisateurhotelgroupeRepository utilisateurhotelgroupeRepository;
    @Autowired
    private UtilisateurhotelgroupeMapper utilisateurhotelgroupeMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public UtilisateurhotelgroupeDto addData(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException, JRException {
        utilisateurhotelgroupeDto.setUser("jsddsdksj");
        CHeckNull.checkEmail(utilisateurhotelgroupeDto.getEmail());
        checkeEmailIsAlreadyUsed(utilisateurhotelgroupeDto.getEmail());
        Role role = roleService.searchRoleByIntitule(utilisateurhotelgroupeDto.getRole().getIntitule());
        Utilisateurhotelgroupe utilisateurhotelgroupe = utilisateurhotelgroupeMapper.toEntity(utilisateurhotelgroupeDto);
        utilisateurhotelgroupe.setRole(role);
        return utilisateurhotelgroupeMapper.toDto(utilisateurhotelgroupeRepository.save(utilisateurhotelgroupe));
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
    public String deleteByEmail(String email) throws HotelException {
        Utilisateurhotelgroupe utilisateurhotelgroupe = searchByEmail(email);
        utilisateurhotelgroupeRepository.deleteById(utilisateurhotelgroupe.getId());
        return null;
    }

    @Override
    public List<UtilisateurhotelgroupeDto> listUtilisateurhotelgroupeDto() {
        List<Utilisateurhotelgroupe> utilisateurhotelgroupes= utilisateurhotelgroupeRepository.findAll();
        return utilisateurhotelgroupes.stream().map(utilisateurhotelgroupe -> utilisateurhotelgroupeMapper.toDto(utilisateurhotelgroupe)).collect(Collectors.toList());
    }


    @Override
    public UtilisateurhotelgroupeDto update(UtilisateurhotelgroupeDto utilisateurhotelgroupeDto) throws HotelException {
        Utilisateurhotelgroupe utilisateurhotelgroupe= searchByEmail(utilisateurhotelgroupeDto.getEmail());
        utilisateurhotelgroupeMapper.copy(utilisateurhotelgroupeDto, utilisateurhotelgroupe);
        return utilisateurhotelgroupeMapper.toDto(utilisateurhotelgroupeRepository.save(utilisateurhotelgroupe));
    }

    private void checkeEmailIsAlreadyUsed(String email) throws HotelException {
        if (utilisateurhotelgroupeRepository.findUtilisateurhotelgroupeByEmail(email).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }

    @Override
    public List<UtilisateurhotelgroupeDto> getAll() {
        return null;
    }

}