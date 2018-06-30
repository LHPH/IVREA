package mx.gob.ivrea.paginacion;

import mx.gob.ivrea.base.BaseModel;

public class Restriccion extends BaseModel {

    private static final long serialVersionUID=13568923429L;

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
