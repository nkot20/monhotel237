package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

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

    @Column(name = "datedebut", nullable = false)
    private LocalDate datedebut;

    @Column(name = "datefin", nullable = false)
    private LocalDate datefin;

    @Column(name = "statut", nullable = false)
    private Integer statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employe", nullable = false)
    private Employe employe;

    @Column(name = "datemodif", nullable = false)
    private Instant datemodif;

    @Column(name = "user", nullable = false, length = 50)
    private String user;


}