package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonneDto {
    private String nom;
    private String prenom;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String datenaissance;
    private String email;
    private String tel1;
    private String tel2;
    private Character sexe;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date datemodif;
    private String user;
    private String fonction;
}
