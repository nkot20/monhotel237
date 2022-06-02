package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.repository;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
    Optional<Chambre> findChambreByNumero(Integer numero);

    //Map<Object, Object> findChambreByKeyword(String keyword);
    @Query(value = "SELECT idchambre, numero, etage, nblits, nbplace, datemodif, username, hotel, categorie, statut FROM chambres WHERE chambres.idchambre NOT IN (SELECT idChambre FROM chambres INNER JOIN reservation ON reservation.client = chambres.idchambre)", nativeQuery = true)
    public Optional<List<Chambre>> findChanbreNoReserve();
}