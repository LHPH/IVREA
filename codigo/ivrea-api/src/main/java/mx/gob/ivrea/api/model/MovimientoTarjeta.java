package mx.gob.ivrea.api.model;

import mx.gob.ivrea.base.BaseModel;

public class MovimientoTarjeta extends BaseModel {

    private static final long serialVersionUID=2390758424L;

    private String fecha;
    private String concepto;
    private String cantidad;

    public String getFecha() {

        return fecha;
    }

    public void setFecha(String fecha) {

        this.fecha = fecha;
    }

    public String getConcepto() {

        return concepto;
    }

    public void setConcepto(String concepto) {

        this.concepto = concepto;
    }

    public String getCantidad() {

        return cantidad;
    }

    public void setCantidad(String cantidad) {

        this.cantidad = cantidad;
    }

}
