package mx.gob.ivrea.paginacion;


public enum TipoCelda {

TEXTO("texto"), ENLACE("enlace"), ICONO("icono"), FORM("form");

    private String desc;

    private TipoCelda(final String val) {
        desc = val;
    }

    public String getDesc() {

        return desc;
    }

}
