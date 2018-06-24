package mx.gob.ivrea.paginacion;


public class Filtro extends Pagina{
	public Filtro() {
        super();
    }

    public Filtro(long totalRegistros, long totalPaginas, long paginaActual) {
        super(totalRegistros, totalPaginas, paginaActual);
    }
}
