package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Client;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.mapper.ClientMapper;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository.ClientRepository;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IClient;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils.CHeckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class ClientServiceImpl implements IClient {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDto addData(ClientDto clientDto) throws HotelException {
        CHeckNull.checkEmail(clientDto.getEmail());
        checkEmailIsAlreadyUsed(clientDto.getEmail());
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDto)));
    }

    @Override
    public void deleteByEmail(String email) throws HotelException {
        Client client = searchByEmail(email);
        clientRepository.deleteById(client.getId());
    }

    @Override
    public ClientDto searchById(Integer id) throws HotelException {
        return clientMapper.toDto(clientRepository.findById(id).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }


    @Override
    public Client searchByEmail(String email) throws HotelException {
        CHeckNull.checkEmail(email);
        return clientRepository.findClientByEmail(email).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND));
    }

    @Override
    public ClientDto searchByEmailDto(String email) throws HotelException {
        CHeckNull.checkEmail(email);
        return clientMapper.toDto(clientRepository.findClientByEmail(email).orElseThrow(() -> new HotelException(ErrorInfo.RESSOURCE_NOT_FOUND)));
    }

    @Override
    public ClientDto update(ClientDto clientDto) throws HotelException {
        Client client = searchByEmail(clientDto.getEmail());
        clientMapper.copy(clientDto, client);
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public ClientDto getAll() {
        return null;
    }

    private void checkEmailIsAlreadyUsed(String email) throws HotelException {
        if (clientRepository.findClientByEmail(email).isPresent()) throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_ALREADY_USED);
    }
}