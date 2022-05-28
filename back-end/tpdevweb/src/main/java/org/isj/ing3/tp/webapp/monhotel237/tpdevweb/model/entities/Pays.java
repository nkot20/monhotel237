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
@Table(name = "pays")
public class Pays implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpays", nullable = false)
    private Integer id;

    @Column(name = "nompays", nullable = false, length = 50)
    private String nompays;

    @Column(name = "datemodif", nullable = false)
    private Instant datemodif;

    @Column(name = "user", nullable = false, length = 50)
    private String user;

}