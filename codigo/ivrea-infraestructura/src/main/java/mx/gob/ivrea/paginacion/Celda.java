package mx.gob.ivrea.paginacion;


public class Celda {

 private String contenido;
    private String enlace;
    private TipoCelda tipo;

    public Celda() {
        super();
    }

    public Celda(String contenido, TipoCelda tipo) {
        super();
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public Celda(String contenido, TipoCelda tipo, String enlace) {
        super();
        this.contenido = contenido;
        this.tipo = tipo;
        this.enlace = enlace;
    }

    public String getContenido() {

        return contenido;
    }

    public void setContenido(String contenido) {

        this.contenido = contenido;
    }

    public String getEnlace() {

        return enlace;
    }

    public void setEnlace(String enlace) {

        this.enlace = enlace;
    }

    public TipoCelda getTipo() {

        return tipo;
    }

    public void setTipo(TipoCelda tipo) {

        this.tipo = tipo;
    }

}
