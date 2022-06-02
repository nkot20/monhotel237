package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationIdDto implements Serializable {
    private ClientDto client;
    private ChambreDto chambre;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date datedebut;
}
