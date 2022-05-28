package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriechambreDto implements Serializable {
    private Integer id;
    private String libelle;
    private String description;
    private Integer datemodif;
    private String username;
    private byte[] imge;
    private HotelDto hotel;
}
