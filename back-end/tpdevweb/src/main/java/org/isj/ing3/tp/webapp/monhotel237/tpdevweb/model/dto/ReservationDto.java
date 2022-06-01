package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto implements Serializable {
    private ReservationIdDto id;
    private Integer nbadulte;
    private Integer nbenfant;
    private Date datefin;
    private Integer quantite;
    private String type;
}
