package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
public class Personne {
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "datenaissance", nullable = false)
    private LocalDate datenaissance;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "tel1", nullable = false, length = 20)
    private String tel1;

    @Column(name = "tel2", length = 20)
    private String tel2;

    @Column(name = "sexe", nullable = false)
    private Character sexe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel", nullable = false)
    private Hotel hotel;

    @Column(name = "datemodif", nullable = false)
    private Instant datemodif;

    @Column(name = "user", nullable = false, length = 50)
    private String user;
}
