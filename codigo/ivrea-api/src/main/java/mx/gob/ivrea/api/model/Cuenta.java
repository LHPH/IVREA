package mx.gob.ivrea.api.model;

import mx.gob.ivrea.base.BaseModel;

public class Cuenta extends BaseModel {

    private String numeroCuenta;
    private String saldo;
    private Tarjeta tarjeta;

    public String getNumeroCuenta() {

        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {

        this.numeroCuenta = numeroCuenta;
    }

    public String getSaldo() {

        return saldo;
    }

    public void setSaldo(String saldo) {

        this.saldo = saldo;
    }

    public Tarjeta getTarjeta() {

        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {

        this.tarjeta = tarjeta;
    }

}
