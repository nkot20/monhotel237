package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriechambreDto implements Serializable {
    private String libelle;
    private String description;
    private Date datemodif = new Date();
    private String username;
    private byte[] imge;
    private String prix;
}
