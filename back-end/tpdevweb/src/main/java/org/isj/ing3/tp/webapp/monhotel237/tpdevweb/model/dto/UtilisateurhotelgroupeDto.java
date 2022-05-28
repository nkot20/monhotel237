package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UtilisateurhotelgroupeDto implements Serializable {
    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate datenaissance;
    private String email;
    private String tel1;
    private String tel2;
    private Character sexe;
    private HotelDto hotel;
    private Instant datemodif;
    private String user;
    private RoleDto role;
}
