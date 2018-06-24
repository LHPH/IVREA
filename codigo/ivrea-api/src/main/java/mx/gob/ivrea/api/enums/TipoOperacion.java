package mx.gob.ivrea.api.enums;

public enum TipoOperacion {

    DESCONOCIDO(0), DEPOSITO(1), TRANSFERENCIA(2),RETIRO(3);

    private int valor;

    private TipoOperacion(int val) {

        this.valor = val;
    }

    public int getValor() {

        return valor;
    }

    public static TipoOperacion getInstance(int val) {

        TipoOperacion tipo = TipoOperacion.DESCONOCIDO;
        for (TipoOperacion t : TipoOperacion.values()) {
            if (t.getValor() == val) {
                tipo = t;
                break;
            }
        }
        return tipo;
    }
}
