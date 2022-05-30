package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ChambreMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.ChambreRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IChambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class ChambreServiceImpl implements IChambre {

    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private ChambreMapper chambreMapper;

    @Override
    public ChambreDto addData(ChambreDto chambreDto) throws HotelException {
        CHeckNull.checkNumero(chambreDto.getNumero());
        checkIntituleIsAlreadyUsed(chambreDto.getNumero());
        return chambreMapper.toDto(chambreRepository.save(chambreMapper.toEntity(chambreDto)));
    }

    @Override
    public ChambreDto searchById(Integer id) throws HotelException {
        return chambreMapper.toDto(chambreRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public Chambre searchChambreByNumber(Integer number) throws HotelException {
        CHeckNull.checkNumero(number);
        return chambreRepository.findChambreByNumero(number).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public ChambreDto searchChambreByNumberDto(Integer number) throws HotelException {
        CHeckNull.checkNumero(number);
        return chambreMapper.toDto(chambreRepository.findChambreByNumero(number).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    @Override
    public void deleteByNumber(Integer number) throws HotelException {
        Chambre chambre = searchChambreByNumber(number);
        chambreRepository.deleteById(chambre.getId());
    }

    @Override
    public ChambreDto update(ChambreDto chambreDto) throws HotelException {
        Chambre entity = searchChambreByNumber(chambreDto.getNumero());
        chambreMapper.copy(chambreDto, entity);
        return chambreMapper.toDto(chambreRepository.save(entity));
    }

    private void checkIntituleIsAlreadyUsed(Integer numero) throws HotelException {
        if (chambreRepository.findChambreByNumero(numero).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }

    @Override
    public ChambreDto getAll() {
        return null;
    }

    @Override
    public List<ChambreDto> listChambres() {
        return chambreRepository.findAll().stream().map(chambre -> chambreMapper.toDto(chambre))
                .collect(Collectors.toList());
    }


    //@Override
   // public List<ChambreDto> searchChambresByKeyword(String keyword) {
     //   return null;/* chambreRepository.findChambreByKeyword(keyword).get().stream()
             //   .map(chambreMapper::toDto)
            //    .collect(Collectors.toList());*/
  //  }

}