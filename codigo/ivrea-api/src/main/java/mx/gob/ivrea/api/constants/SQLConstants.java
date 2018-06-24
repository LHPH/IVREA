package mx.gob.ivrea.api.constants;

public final class SQLConstants {

    public static final String CONSULTA_MOVIMIENTOS_TARJETA = new StringBuilder(
            "SELECT MOV.DESCRIPCION,MOV.CANTIDAD,MOV.FECHA FROM ")
                    .append(" MOVIMIENTO MOV INNER JOIN CUENTA CU ON MOV.CVECUENTA=CU.CVECUENTA ")
                    .append(" INNER JOIN TARJETA TAR ON TAR.CVECUENTA=CU.CVECUENTA WHERE TAR.NUMERO_TARJETA=:")
                    .append(ParametrosConstants.PARAM_SQL_NUM_TARJETA).append(" ORDER BY MOV.FECHA DESC ").toString();

    public static final String CONSULTA_NUM_TOTAL_MOVIMIENTOS_TARJETA = new StringBuilder(
            "SELECT COUNT(MOV.CVEMOVIMIENTO) FROM ")
                    .append(" MOVIMIENTO MOV INNER JOIN CUENTA CU ON MOV.CVECUENTA=CU.CVECUENTA ")
                    .append(" INNER JOIN TARJETA TAR ON TAR.CVECUENTA=CU.CVECUENTA WHERE TAR.NUMERO_TARJETA=:")
                    .append(ParametrosConstants.PARAM_SQL_NUM_TARJETA).append(" ORDER BY MOV.FECHA DESC ").toString();

    private SQLConstants() {

    }

}
