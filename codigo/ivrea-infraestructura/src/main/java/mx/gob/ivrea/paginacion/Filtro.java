package mx.gob.ivrea.paginacion;


public class Filtro extends Pagina{

    private static final long serialVersionUID=2349896539L;

	public Filtro() {
        super();
    }

    public Filtro(long totalRegistros, long totalPaginas, long paginaActual) {
        super(totalRegistros, totalPaginas, paginaActual);
    }
}
