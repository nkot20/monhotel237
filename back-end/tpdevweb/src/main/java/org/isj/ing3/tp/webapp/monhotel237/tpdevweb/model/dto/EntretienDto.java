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
public class EntretienDto implements Serializable {
    private Integer numero;
    private LocalDate datedebut;
    private LocalDate datefin;
    private Integer statut;
    private EmployeDto employe;
    private Instant datemodif;
    private String user;
}
