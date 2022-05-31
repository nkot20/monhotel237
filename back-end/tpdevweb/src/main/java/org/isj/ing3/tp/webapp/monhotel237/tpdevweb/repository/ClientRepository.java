package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ClientDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findClientByEmail(String email);

    Optional<Client> findClientByNom(String nom);

}