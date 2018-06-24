package mx.gob.ivrea.utils;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import mx.gob.ivrea.base.BaseHelper;
import mx.gob.ivrea.reportes.Exporter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperHelper extends BaseHelper implements Exporter {

    public byte[] exportarPDF(String nombreJasper, Map<String, Object> parametros) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            JREmptyDataSource emptyDS = new JREmptyDataSource();
            JasperReport report = (JasperReport) JRLoader
                    .loadObject(ClassLoader.getSystemResourceAsStream(nombreJasper));
            JasperPrint print = JasperFillManager.fillReport(report, parametros, emptyDS);
            return JasperExportManager.exportReportToPdf(print);
        } catch (Exception e) {
            //this.logger.error("No se pudo genererar el archivo PDF {} Traza", e.getMessage(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] exportarXLS(String nombreJasper, Map<String, Object> parametros) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            JREmptyDataSource emptyDS = new JREmptyDataSource();

            JasperReport reporte = (JasperReport) JRLoader
                    .loadObject(ClassLoader.getSystemResourceAsStream(nombreJasper));
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, emptyDS);

            JRXlsxExporter exporter = new JRXlsxExporter();

            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES, new String[] { "Hoja 1" });
            exporter.exportReport();
        } catch (Exception e) {
            //this.logger.debug(e.getMessage(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] exportarDOC(String nombreJasper, Map<String, Object> parametros) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            JREmptyDataSource emptyDS = new JREmptyDataSource();

            JasperReport reporte = (JasperReport) JRLoader.loadObject(ClassLoader.getSystemResource((nombreJasper)));
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, emptyDS);

            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
        } catch (Exception e) {
            //this.logger.debug(e.getMessage(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

}
