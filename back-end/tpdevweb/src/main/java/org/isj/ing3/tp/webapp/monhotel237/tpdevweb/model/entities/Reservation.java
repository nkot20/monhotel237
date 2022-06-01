package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @EmbeddedId
    private ReservationId id;

    @Column(name = "nbadulte", nullable = false)
    private Integer nbadulte;

    @Column(name = "nbenfant", nullable = false)
    private Integer nbenfant;

    @Column(name = "datefin", nullable = false)
    private Date datefin;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    @Column(name = "type", nullable = false)
    private String type;

}