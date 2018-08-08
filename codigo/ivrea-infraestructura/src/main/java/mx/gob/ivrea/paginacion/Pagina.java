package mx.gob.ivrea.paginacion;

import java.util.Collection;
import java.util.List;

import mx.gob.ivrea.base.BaseModel;

public class Pagina extends BaseModel {

    private static final long serialVersionUID=238976499969L;

    private long totalRegistros;
    private long totalPaginas;
    private long paginaActual;
    private int tamanoPagina;
    private Collection<? extends BaseModel> datos;
    private List<Restriccion> restricciones;

    public Pagina() {

        super();
    }

    public Pagina(long totalRegistros, long totalPaginas, long paginaActual) {

        super();
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.paginaActual = paginaActual;
    }

    public long obtenerTotalPaginas(int maxResults) {

        return (long) Math.ceil((maxResults * 10 / this.getTamanoPagina()) / 10d);
    }

    public int obtenerPrimerResultado() {

        return (int) (this.getPaginaActual() - 1) * this.getTamanoPagina();
    }

    public long getTotalRegistros() {

        return totalRegistros;
    }

    public void setTotalRegistros(long totalRegistros) {

        this.totalRegistros = totalRegistros;
    }

    public long getTotalPaginas() {

        return totalPaginas;
    }

    public void setTotalPaginas(long totalPaginas) {

        this.totalPaginas = totalPaginas;
    }

    public long getPaginaActual() {

        return paginaActual;
    }

    public void setPaginaActual(long paginaActual) {

        this.paginaActual = paginaActual;
    }

    public int getTamanoPagina() {

        if(tamanoPagina==0){
            tamanoPagina = ConstantsPagination.DEFAULT_TAM_PAGINA;
        }
        return tamanoPagina;
    }

    public void setTamanoPagina(int tamanoPagina) {

        this.tamanoPagina = tamanoPagina;
    }

    public Collection<? extends BaseModel> getDatos() {

        return datos;
    }

    public void setDatos(Collection<? extends BaseModel> datos) {

        this.datos = datos;
    }

    public List<Restriccion> getRestricciones() {

        return restricciones;
    }

    public void setRestricciones(List<Restriccion> restricciones) {

        this.restricciones = restricciones;
    }

}
