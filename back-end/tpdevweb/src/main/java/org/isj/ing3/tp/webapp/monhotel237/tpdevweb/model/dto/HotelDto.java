package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelDto implements Serializable {

    private String nom;
    private String tel;
    private String email;
    private String devise;
    private String slogan;
    private String adresse;
    private String langue;
    private String lienfacebook;
    private String lienwhatsapp;
    private byte[] logo;
    private Integer nbetage;
    private String siteweb;
    private String ville;
    private String pays;
    //private CategorieDto categorie;
    private Date datemadif;
    private String user;
}
