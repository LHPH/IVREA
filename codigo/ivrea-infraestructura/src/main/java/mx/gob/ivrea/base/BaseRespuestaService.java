package mx.gob.ivrea.base;

import java.io.Serializable;

public class BaseRespuestaService<O, E> implements Serializable {

    private static final long serialVersionUID=20900087654L;

    private O objeto;
    private E estatus;
    private BaseMessage mensaje;

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

    public void setMensaje(BaseMessage message){
        this.mensaje = message;
    }

    public BaseMessage getMensaje(){
        if(this.mensaje==null){
            return new BaseMessage();
        }
        return this.getMensaje();
    }

}
