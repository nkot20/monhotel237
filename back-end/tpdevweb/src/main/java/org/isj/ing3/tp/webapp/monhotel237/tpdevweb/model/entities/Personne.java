package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
@Data
public class Personne {
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "datenaissance", nullable = false)
    private String datenaissance;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "tel1", nullable = false, length = 20)
    private String tel1;

    @Column(name = "tel2", length = 20)
    private String tel2;

    @Column(name = "sexe", nullable = false)
    private Character sexe;


    @Column(name = "datemodif", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemodif = new Date();

    @Column(name = "user", nullable = false, length = 50)
    private String user;
}
