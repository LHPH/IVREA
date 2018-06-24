package mx.gob.ivrea.api.enums;

public enum EstadoTarjeta {

    ACTIVA(1), INACTIVA(0);

    private int valor;

    private EstadoTarjeta(int val) {

        this.valor = val;
    }

    public int getValor() {

        return this.valor;
    }

}
