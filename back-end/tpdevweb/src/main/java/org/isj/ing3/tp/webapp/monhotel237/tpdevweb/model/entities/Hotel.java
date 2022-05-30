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
@Table(name = "hotel")
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhotel", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "tel", nullable = false, length = 20, unique = true)
    private String tel;

    @Column(name = "email", nullable = false, length = 20, unique = true)
    private String email;

    @Column(name = "devise", nullable = false, length = 15)
    private String devise;

    @Column(name = "slogan", length = 50)
    private String slogan;

    @Column(name = "adresse", nullable = false, length = 50)
    private String adresse;

    @Column(name = "langue", nullable = false, length = 50)
    private String langue;

    @Column(name = "lienfacebook", length = 50)
    private String lienfacebook;

    @Column(name = "lienwhatsapp", length = 50)
    private String lienwhatsapp;

    @Column(name = "logo", nullable = false)
    private byte[] logo;

    @Column(name = "nbetage", nullable = false)
    private Integer nbetage;

    @Column(name = "siteweb", length = 50)
    private String siteweb;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ville", nullable = false)
    private Ville ville;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categorie", nullable = false)
    private Categorie categorie;

    @Column(name = "datemadif", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemadif = new Date();

    @Column(name = "user", nullable = false, length = 50)
    private String user;


}