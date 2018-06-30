package mx.gob.ivrea.base;

import java.io.Serializable;

public class BaseRespuestaService<O, E> implements Serializable {

    private static final long serialVersionUID=20900087654L;

    private O objeto;
    private E estatus;

    public BaseRespuestaService() {

    }

    public BaseRespuestaService(O objeto, E estatus) {

        this.objeto = objeto;
        this.estatus = estatus;
    }

    public O getObjeto() {

        return objeto;
    }

    public void setObjeto(O objeto) {

        this.objeto = objeto;
    }

    public E getEstatus() {

        return estatus;
    }

    public void setEstatus(E estatus) {

        this.estatus = estatus;
    }

}
