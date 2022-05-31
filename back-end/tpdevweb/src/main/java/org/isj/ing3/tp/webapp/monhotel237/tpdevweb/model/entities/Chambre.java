package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "chambres")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchambre", nullable = false)
    private Integer id;

    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "etage", nullable = false)
    private Integer etage;

    @Column(name = "nblits", nullable = false)
    private Integer nblits;

    @Column(name = "nbplace", nullable = false)
    private Integer nbplace;

    @Column(name = "datemodif", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemodif = new Date();

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel", nullable = false)
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categorie", nullable = false)
    private Categoriechambre categoriechambre;


}