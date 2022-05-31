package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "entretien")
public class Entretien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identretien", nullable = false)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "datedebut", nullable = false)
    private Date datedebut;

    @Column(name = "datefin", nullable = false)
    private Date datefin;

    @Column(name = "statut", nullable = false)
    private String statut;

    @Column(name = "priorite", nullable = false)
    private String priorite;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employe", nullable = false)
    private Employe employe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chambre", nullable = false)
    private Chambre chambre;

    @Column(name = "datemodif", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemodif = new Date();

    @Column(name = "user", nullable = false, length = 50)
    private String user;


}