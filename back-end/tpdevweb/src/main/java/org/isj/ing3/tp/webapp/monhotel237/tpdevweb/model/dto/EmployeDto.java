package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeDto implements Serializable {

    private String nom;
    private String prenom;
    private LocalDate datenaissance;
    private String email;
    private String tel1;
    private String tel2;
    private Character sexe;
    private HotelDto hotel;
    private Date datemodif;
    private String user;
}
