package mx.gob.ivrea.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormatoLogger {

    private Logger logger = null;
    private static final String CLASE = "Clase:";
    private static final String METODO = "Metodo:";
    private static final String FORMATO = "%n%22s %s%n%22s %s%n%22s %s";
    private static final String ENTRADA = "Entrada:";
    private static final String SALIDA = "Salida:";
    private static final String CANTIDAD = "Cantidad: ";
    private static final String SALTO_LINEA = "\n";
    private static final String TIPO = "Tipo: ";
    private static final String NULO = "NULL";

    public void escEntrada(String clase, String metodo, LoggerAnnotation logAnot, Object[] args) {

        StringBuilder cadena = new StringBuilder();
        cadena.append(CANTIDAD);
        cadena.append(args.length);
        for (int cont = 0; cont < args.length; cont++) {
            cadena.append(SALTO_LINEA);
            cadena.append(TIPO);
            cadena.append(args[0] == null ? NULO : args[0].getClass().getName());
        }
        logger = LoggerFactory.getLogger(logAnot.tipo().name());
        final String message = String.format(FORMATO, CLASE, clase, METODO, metodo, ENTRADA, cadena.toString());
        escribir(message, logAnot.categoria());
    }

    public void escSalida(String clase, String metodo, LoggerAnnotation logAnot, Object objReturn) {

        logger = LoggerFactory.getLogger(logAnot.tipo().name());
        String message = String.format(FORMATO, CLASE, clase, METODO, metodo, SALIDA,
                null == objReturn ? "void" : objReturn.getClass().getName());
        escribir(message, logAnot.categoria());
    }

    private void escribir(String mensaje, Categoria categoria) {

        switch (categoria) {
            case INFO:
                this.logger.info(mensaje);
                break;
            case DEBUG:
                this.logger.debug(mensaje);
                break;
            case ERROR:
                this.logger.error(mensaje);
                break;
        }
    }

}
