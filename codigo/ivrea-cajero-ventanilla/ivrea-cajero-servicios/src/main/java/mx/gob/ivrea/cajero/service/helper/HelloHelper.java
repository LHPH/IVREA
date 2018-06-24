package mx.gob.ivrea.cajero.service.helper;

import org.springframework.stereotype.Component;

import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.TipoLogger;

@Component
public class HelloHelper {

    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public String generarNombre(String param1) {

        return "Hello Helper" + param1;
    }

}
