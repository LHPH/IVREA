package externo.rest.model;

import java.io.Serializable;
import java.util.Date;

public class Recibo implements Serializable {

    private String idTransaccion;
    private String mensaje;
    private boolean exito;
    private Date fecha;

    public String getIdTransaccion() {

        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {

        this.idTransaccion = idTransaccion;
    }

    public String getMensaje() {

        return mensaje;
    }

    public void setMensaje(String mensaje) {

        this.mensaje = mensaje;
    }

    public boolean isExito() {

        return exito;
    }

    public void setExito(boolean exito) {

        this.exito = exito;
    }

    public Date getFecha() {

        return fecha;
    }

    public void setFecha(Date fecha) {

        this.fecha = fecha;
    }

}
