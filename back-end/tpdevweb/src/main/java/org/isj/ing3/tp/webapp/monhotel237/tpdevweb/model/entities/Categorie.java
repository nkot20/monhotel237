package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcat", nullable = false)
    private Integer id;

    @Column(name = "intitule", nullable = false)
    private Integer intitule;

    @Column(name = "datemodif", nullable = false)
    private Instant datemodif;

    @Column(name = "user", nullable = false, length = 50)
    private String user;




}