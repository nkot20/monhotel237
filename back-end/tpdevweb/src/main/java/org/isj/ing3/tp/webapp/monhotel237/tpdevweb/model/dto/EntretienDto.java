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
public class EntretienDto implements Serializable {
    private Integer numero;
    private Date datedebut;
    private Date datefin;
    private Integer statut;
    private EmployeDto employe;
    private Date datemodif;
    private String user;
}
