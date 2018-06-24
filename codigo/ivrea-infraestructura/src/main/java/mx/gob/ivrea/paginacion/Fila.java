package mx.gob.ivrea.paginacion;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Celda> celdas;

    public Fila() {

        celdas = new ArrayList<Celda>();
    }

    public List<Celda> getCeldas() {

        return celdas;
    }

    public void setCeldas(List<Celda> celdas) {

        this.celdas = celdas;
    }

}
