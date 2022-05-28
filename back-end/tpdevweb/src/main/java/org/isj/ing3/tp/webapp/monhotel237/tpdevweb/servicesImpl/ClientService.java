package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Client;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ClientMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.ClientRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class ClientService implements IClient {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDto addData(ClientDto clientDto) {
        return clientMapper.toDto(repository.save(clientMapper.toEntity(clientDto)));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ClientDto searchById(Integer id) throws HotelException {
        return clientMapper.toDto(repository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public ClientDto update(ClientDto clientDto) throws HotelException {
        ClientDto data = searchById(clientDto.getId());
        Client entity = clientMapper.toEntity(clientDto);
        clientMapper.copy(data, entity);
        return addData(clientMapper.toDto(entity));
    }

    @Override
    public ClientDto getAll() {
        return null;
    }


    public Client searchByEmail(String email) {
        return null;
    }
}