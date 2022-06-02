package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureReservation {

    private String libelle;
    private String DateDebut;
    private String DateFin;
    private String prix;
    private String NombreJours;
    private String Total;
    private String Nom;
    private String Email;
    private String Telephone;

}
