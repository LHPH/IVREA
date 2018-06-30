package mx.gob.ivrea.api.model;

import mx.gob.ivrea.base.BaseModel;

public class Tarjeta extends BaseModel {

    private static final long serialVersionUID=86468536890L;

    private String numeroTarjeta;
    private String nip;
    private boolean activa;

    public String getNumeroTarjeta() {

        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {

        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNip() {

        return nip;
    }

    public void setNip(String nip) {

        this.nip = nip;
    }

    public boolean isActiva() {

        return activa;
    }

    public void setActiva(boolean activa) {

        this.activa = activa;
    }

}
