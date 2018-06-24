package mx.gob.ivrea.cajero.service.business;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import mx.gob.ivrea.base.BaseBusinessService;
import mx.gob.ivrea.cajero.interfaces.HolaRemote;
import mx.gob.ivrea.cajero.service.helper.HelloHelper;
import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.TipoLogger;

@Stateless(name = "holaBusiness", mappedName = "holaBusiness")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class HolaBusiness extends BaseBusinessService implements HolaRemote {

    @Autowired
    HelloHelper helloHelper;

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public String hola() {

        // logger.info("En Business Hola");
        helloHelper.generarNombre(" LUIS ");
        return "Hola Mundo";
    }

}
