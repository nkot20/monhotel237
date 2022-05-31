package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Utilisateurhotelgroupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurhotelgroupeRepository extends JpaRepository<Utilisateurhotelgroupe, Integer> {
    Optional<Utilisateurhotelgroupe> findUtilisateurhotelgroupeByEmail(String email);
}