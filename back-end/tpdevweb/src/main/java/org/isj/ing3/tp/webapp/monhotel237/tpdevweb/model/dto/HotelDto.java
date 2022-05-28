package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.CategorieDto;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelDto implements Serializable {
    private Integer id;
    private String nom;
    private String tel;
    private String devise;
    private String slogan;
    private String adresse;
    private String langue;
    private String lienfacebook;
    private String lienwhatsapp;
    private byte[] logo;
    private Integer nbetage;
    private String siteweb;
    private VilleDto ville;
    private CategorieDto categorie;
    private Instant datemadif;
    private String user;
}
