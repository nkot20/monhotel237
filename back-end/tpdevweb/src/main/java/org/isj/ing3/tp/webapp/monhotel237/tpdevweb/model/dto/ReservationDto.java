package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto implements Serializable {
    private ReservationIdDto id;
    private Integer nbadulte;
    private Integer nbenfant;
    private LocalDate datefin;
    private Integer quantite;
}
