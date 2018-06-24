package mx.gob.ivrea.paginacion;

import mx.gob.ivrea.base.BaseModel;

public class Restriccion extends BaseModel {

    private String nomParametro;
    private Object valor;

    public String getNomParametro() {

        return nomParametro;
    }

    public void setNomParametro(String nomParametro) {

        this.nomParametro = nomParametro;
    }

    public Object getValor() {

        return valor;
    }

    public void setValor(Object valor) {

        this.valor = valor;
    }

}
