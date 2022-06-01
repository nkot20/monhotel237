package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Chambre;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntretienDto implements Serializable {
    private Integer numero;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private String datedebut;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private String datefin;
    private String statut;
    private String priorite;
    private EmployeDto employe;
    private ChambreDto chambre;
    private Date datemodif;
    private String user;
}
