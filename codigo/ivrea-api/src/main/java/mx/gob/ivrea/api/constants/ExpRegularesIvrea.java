package mx.gob.ivrea.api.constants;

import mx.gob.ivrea.constants.ExpRegulares;

public class ExpRegularesIvrea implements ExpRegulares{


    public static final String EXP_REG_NUM_CUENTA_IVREA="^[0-9]{10}$";
    public static final String EXP_REG_NUM_TARJETA_IVREA="^[0-9]{3}\\-[0-9]{3}\\-[0-9]{2}$";
    public static final String EXP_REG_NIP = "^[0-9]{4}$";

    private ExpRegularesIvrea(){}

}