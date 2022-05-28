package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReservationId implements Serializable {
    private static final long serialVersionUID = -1208939586918046080L;
    @Column(name = "client", nullable = false)
    private Integer client;
    @Column(name = "chambre", nullable = false)
    private Integer chambre;
    @Column(name = "datedebut", nullable = false)
    private LocalDate datedebut;



    @Override
    public int hashCode() {
        return Objects.hash(datedebut, client, chambre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReservationId entity = (ReservationId) o;
        return Objects.equals(this.datedebut, entity.datedebut) &&
                Objects.equals(this.client, entity.client) &&
                Objects.equals(this.chambre, entity.chambre);
    }
}