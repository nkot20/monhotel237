package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Categoriechambre;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChambreDto implements Serializable {
    private Integer numero;
    private Integer etage;
    private Integer nblits;
    private Integer nbplace;
    private Date datemodif;
    private String username;
    private String statut;
    private CategoriechambreDto categoriechambre;
}
