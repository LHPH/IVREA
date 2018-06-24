package mx.gob.ivrea.reportes;

import java.util.Map;

public interface Exporter {

    byte[] exportarPDF(String nombreJasper, Map<String, Object> parametros);

    byte[] exportarXLS(String nombreJasper, Map<String, Object> parametros);

    byte[] exportarDOC(String nombreJasper, Map<String, Object> parametros);

}
