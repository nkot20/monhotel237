package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "categoriechambre")
public class Categoriechambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcatchambre", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false, length = 50, unique = true)
    private String libelle;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "datemodif", nullable = false)
    private Integer datemodif;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "imge", nullable = false)
    private byte[] imge;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel", nullable = false)
    private Hotel hotel;


}