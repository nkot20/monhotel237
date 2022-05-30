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
@Table(name = "ville")
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idville", nullable = false)
    private Integer id;

    @Column(name = "nomville", nullable = false, length = 50, unique = true)
    private String nomville;

    @Column(name = "datemodif", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemodif = new Date();

    @Column(name = "user", nullable = false, length = 50)
    private String user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    private Pays pays;


}