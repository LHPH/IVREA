package mx.gob.ivrea.api.model;

import java.util.Date;

import mx.gob.ivrea.base.BaseModel;

public class Saldo extends BaseModel {

    private static final long serialVersionUID=985753158L;

    private Date fecha;
    private String cuenta;
    private String tarjeta;
    private Double saldo;

    public Date getFecha() {

        return fecha;
    }

    public void setFecha(Date fecha) {

        this.fecha = fecha;
    }

    public String getCuenta() {

        return cuenta;
    }

    public void setCuenta(String cuenta) {

        this.cuenta = cuenta;
    }

    public String getTarjeta() {

        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {

        this.tarjeta = tarjeta;
    }

    public Double getSaldo() {

        return saldo;
    }

    public void setSaldo(Double saldo) {

        this.saldo = saldo;
    }

}
