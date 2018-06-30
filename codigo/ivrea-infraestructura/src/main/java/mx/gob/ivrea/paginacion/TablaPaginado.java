package mx.gob.ivrea.paginacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TablaPaginado implements Serializable{

    private static final long serialVersionUID = 48938938405L;
    // Numero del primer registro de la tabla
    private int numInicio;
    // Numero del registro final de la tabla
    private int numFinal;
    // Numero de registros en la tabla
    private int total;

    private List<Fila> filas;

    public TablaPaginado() {

        filas = new ArrayList<Fila>();
    }

    /**
     * Construye la seccion de la tabla que contiene los registros. No crea el encabezado de la tabla.
     * 
     * @return
     */
    public String construirTabla() {

        StringBuilder tabla = new StringBuilder();
        for (int cont = 0; cont < filas.size(); cont++) {
            Fila fila = filas.get(cont);
            tabla.append(ConstantsPagination.ABRE_FILA);
            for (int cont2 = 0; cont2 < fila.getCeldas().size(); cont2++) {
                Celda celda = fila.getCeldas().get(cont2);
                tabla.append(ConstantsPagination.ABRE_CELDA);
                TipoCelda tipo = celda.getTipo();
                switch (tipo) {
                    case TEXTO:
                        tabla.append(celda.getContenido());
                        break;
                    case ENLACE:
                        tabla.append(ConstantsPagination.ABRE_ENLACE_JAVASCRIPT);
                        tabla.append(celda.getEnlace());
                        tabla.append(ConstantsPagination.CIERRA_ABRE_ENLACE_JAVASCRIPT);
                        tabla.append(celda.getContenido());
                        // tabla.append(ConstantsPagination.CIERRA_ENLACE_JAVASCRIPT);
                        break;
                    case ICONO:
                        break;
                    case FORM:
                        break;
                }
                tabla.append(ConstantsPagination.CIERRA_CELDA);
            }
            tabla.append(ConstantsPagination.CIERRA_FILA);
        }

        return tabla.toString();
    }

    public int getNumInicio() {

        return numInicio;
    }

    public void setNumInicio(int numInicio) {

        this.numInicio = numInicio;
    }

    public int getNumFinal() {

        return numFinal;
    }

    public void setNumFinal(int numFinal) {

        this.numFinal = numFinal;
    }

    public List<Fila> getFilas() {

        return filas;
    }

    public void setFilas(List<Fila> filas) {

        this.filas = filas;
    }

    public int getTotal() {

        return total;
    }

    public void setTotal(int total) {

        this.total = total;
    }

}
