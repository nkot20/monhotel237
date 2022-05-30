package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
    Optional<Chambre> findChambreByNumero(Integer numero);

    //Map<Object, Object> findChambreByKeyword(String keyword);
}