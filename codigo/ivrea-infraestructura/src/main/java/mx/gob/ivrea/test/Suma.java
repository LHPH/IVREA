package mx.gob.ivrea.test;

import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.TipoLogger;

public class Suma {

    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.VISTA)
    public int oper(int a, int b) {

        System.out.println("aaaa");
        return a + b;
    }
}
