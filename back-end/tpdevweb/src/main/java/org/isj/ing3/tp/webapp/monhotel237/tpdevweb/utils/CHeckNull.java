package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.utils;

import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ErrorInfo;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;

import java.util.Objects;

public class CHeckNull {

    public static void checkNumero(Integer numero) throws HotelException {
        if (Objects.isNull(numero)) {
            throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }

    public static void checkEmail(String email) throws HotelException {
        if (Objects.isNull(email)) {
            throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }

    public static void checkLibelle(String libelle) throws HotelException {
        if (Objects.isNull(libelle)) {
            throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }

    public static void checkIntitule(String intitule) throws HotelException {
        if (Objects.isNull(intitule)) {
            throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }

    public static void checkNomPays(String nompays) throws HotelException {
        if (Objects.isNull(nompays)) {
            throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }

    public static void checkNomVille(String nomVille) throws HotelException {
        if (Objects.isNull(nomVille)) {
            throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }

    public static void checkNomClient(String nomClient) throws HotelException {
        if ( (Objects.isNull(nomClient)))
        {throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }

    public static void checkNomEmploye(String nomEmploye) throws HotelException {
        if ( (Objects.isNull(nomEmploye)))
        {throw new HotelException(ErrorInfo.REFERENCE_RESSOURCE_REQUIRED);
        }
    }
}
