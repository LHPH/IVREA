package mx.gob.ivrea.cajero.service.business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import mx.gob.ivrea.api.entity.TarjetaEntity;
import mx.gob.ivrea.api.model.Cliente;
import mx.gob.ivrea.api.entity.ClienteEntity;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.base.BaseAssembler;
import mx.gob.ivrea.base.BaseBusinessService;
import mx.gob.ivrea.cajero.interfaces.ClienteRemote;
import mx.gob.ivrea.cajero.service.persistence.interfaces.ClienteLocal;
import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.LoggerInterceptor;
import mx.gob.ivrea.logger.TipoLogger;

@Stateless(name = "clienteBusiness", mappedName = "clienteBusiness")
@Interceptors({ SpringBeanAutowiringInterceptor.class, LoggerInterceptor.class })
public class ClienteBusiness extends BaseBusinessService implements ClienteRemote {

    @Autowired
    @Qualifier("clienteHelper")
    BaseAssembler<ClienteEntity, Cliente> clienteHelper;

    @EJB
    ClienteLocal clienteDao;

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public Cliente obtenerCliente(Modelo modelo) {

        this.logger.info("Obteniendo cliente de BD");
        try {
            TarjetaEntity tarjeta = clienteDao.obtenerClientePorTarjeta(modelo);
            if (tarjeta.getCuenta() == null) {
                this.logger.info("****************** Cuenta es NULL");
            } else {
                this.logger.info("**************************** ID " + tarjeta.getCuenta().getCveCuenta());
            }

            this.logger.info("" + tarjeta.getCuenta().getCliente());
            Cliente cliente = clienteHelper.aModel(tarjeta.getCuenta().getCliente());
            return cliente;
        } catch (Exception e) {
            this.logger.debug(e.getMessage(), e);
        }
        return null;
    }

}
