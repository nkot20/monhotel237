package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.EmployeDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    Optional<Employe> findEmployeByEmail(String email);

    Optional<Employe> findEmployeByNom(String nom);

    //Optional<EmployeDto> findEmployeByNomDto(String keyword);

    Optional<List<Employe>> findEmployeByNomOrEmail(String motcle1, String motcle2);

}