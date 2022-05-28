package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Client;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ClientMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.ClientRepository;
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
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientMapper clientMapper;

    public ClientDto save(ClientDto clientDto) {
        return clientMapper.toDto(repository.save(clientMapper.toEntity(clientDto)));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public ClientDto findById(Integer id) throws HotelException {
        return clientMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    public ClientDto update(ClientDto clientDto) throws HotelException {
        ClientDto data = findById(clientDto.getId());
        Client entity = clientMapper.toEntity(clientDto);
        clientMapper.copy(data, entity);
        return save(clientMapper.toDto(entity));
    }
}