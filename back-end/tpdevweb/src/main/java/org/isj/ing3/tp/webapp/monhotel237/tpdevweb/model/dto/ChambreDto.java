package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChambreDto implements Serializable {
    private Integer id;
    private Integer numero;
    private Integer etage;
    private Integer nblits;
    private Integer nbplace;
    private Instant datemodif;
    private String username;
    private HotelDto hotel;
    private CategorieDto categorie;
}
