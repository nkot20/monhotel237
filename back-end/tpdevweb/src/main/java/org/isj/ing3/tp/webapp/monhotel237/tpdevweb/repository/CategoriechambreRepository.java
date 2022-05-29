package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categoriechambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriechambreRepository extends JpaRepository<Categoriechambre, Integer> {
        Optional<Categoriechambre> findCategoriechambreByLibelle(String libelle);
}