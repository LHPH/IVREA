package mx.gob.ivrea.cajero.service.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import mx.gob.ivrea.api.entity.CuentaEntity;
import mx.gob.ivrea.api.entity.MovimientoEntity;
import mx.gob.ivrea.api.enums.EstatusOperacion;
import mx.gob.ivrea.api.enums.TipoOperacion;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.api.model.Saldo;
import mx.gob.ivrea.base.BaseAssembler;
import mx.gob.ivrea.base.BaseBusinessService;
import mx.gob.ivrea.base.BaseRespuestaService;
import mx.gob.ivrea.cajero.interfaces.SaldoRemote;
import mx.gob.ivrea.cajero.service.persistence.interfaces.CuentaLocal;
import mx.gob.ivrea.logger.LoggerInterceptor;
import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.TipoLogger;

@Stateless(name = "saldoBusiness", mappedName = "saldoBusiness")
@Interceptors({ SpringBeanAutowiringInterceptor.class, LoggerInterceptor.class })
public class SaldoBusiness extends BaseBusinessService implements SaldoRemote {

    @EJB
    CuentaLocal cuentaDao;

    @Autowired
    @Qualifier("saldoHelper")
    BaseAssembler<CuentaEntity, Saldo> saldoHelper;

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public BaseRespuestaService<Saldo, EstatusOperacion> consultarSaldo(Modelo modelo) {

        this.logger.info("Consultando saldo en BD");
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = new BaseRespuestaService<Saldo, EstatusOperacion>();
        try {
            CuentaEntity cuenta = cuentaDao.obtenerInfoCuentaPorTarjeta(modelo);
            Saldo saldo = saldoHelper.aModel(cuenta);
            saldo.setTarjeta(modelo.getCampo1());
            respuesta.setObjeto(saldo);
            respuesta.setEstatus(EstatusOperacion.EXITOSO);
            this.logger.info("Se hizo la consulta, estatus [{}]", respuesta.getEstatus());
        } catch (Exception e) {
            respuesta.setObjeto(new Saldo());
            respuesta.setEstatus(EstatusOperacion.ERROR);
            this.logger.info("Se hizo la consulta, estatus [{}]", respuesta.getEstatus());
            this.logger.error(e.getMessage(), e);
        }
        return respuesta;
    }

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public BaseRespuestaService<Saldo, EstatusOperacion> depositarSaldo(Modelo modelo) {

        this.logger.info("Depositar saldo en BD");
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = new BaseRespuestaService<Saldo, EstatusOperacion>();
        try {
            CuentaEntity cuenta = cuentaDao.obtenerInfoCuentaPorTarjeta(modelo);
            cuenta.setSaldo(Double.parseDouble(modelo.getCampo3()));
            if (cuenta.getMovimientos() == null) {
                List<MovimientoEntity> movimientos = new ArrayList<MovimientoEntity>();
                cuenta.setMovimientos(movimientos);
            }
            MovimientoEntity movimiento = new MovimientoEntity();
            movimiento.setDescripcion(TipoOperacion.DEPOSITO.name());
            movimiento.setCantidad(modelo.getCampo2());
            movimiento.setFecha(new Date());

            cuenta.getMovimientos().add(movimiento);

            if (movimiento.getCuenta() == null) {
                movimiento.setCuenta(cuenta);
            }
            cuentaDao.actualizarCuenta(cuenta);
            Saldo saldo = saldoHelper.aModel(cuenta);
            saldo.setTarjeta(modelo.getCampo1());
            respuesta.setObjeto(saldo);
            respuesta.setEstatus(EstatusOperacion.EXITOSO);
            this.logger.info("Se hizo el deposito, estatus [{}]", respuesta.getEstatus());
        } catch (Exception e) {
            respuesta.setObjeto(new Saldo());
            respuesta.setEstatus(EstatusOperacion.ERROR);
            this.logger.info("Ocurrio un error, estatus [{}]", respuesta.getEstatus());
            this.logger.error(e.getMessage(), e);
        }
        return respuesta;
    }

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public BaseRespuestaService<Saldo, EstatusOperacion> retirarSaldo(Modelo modelo) {

        this.logger.info("Retirar saldo en BD");
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = new BaseRespuestaService<Saldo, EstatusOperacion>();
        try {
            CuentaEntity cuenta = cuentaDao.obtenerInfoCuentaPorTarjeta(modelo);
            cuenta.setSaldo(Double.parseDouble(modelo.getCampo3()));
            if (cuenta.getMovimientos() == null) {
                List<MovimientoEntity> movimientos = new ArrayList<MovimientoEntity>();
                cuenta.setMovimientos(movimientos);
            }
            MovimientoEntity movimiento = new MovimientoEntity();
            movimiento.setDescripcion(TipoOperacion.RETIRO.name());
            movimiento.setCantidad(modelo.getCampo2());
            movimiento.setFecha(new Date());

            cuenta.getMovimientos().add(movimiento);
            if (movimiento.getCuenta() == null) {
                movimiento.setCuenta(cuenta);
            }

            cuentaDao.actualizarCuenta(cuenta);
            Saldo saldo = saldoHelper.aModel(cuenta);
            saldo.setTarjeta(modelo.getCampo1());
            respuesta.setObjeto(saldo);
            respuesta.setEstatus(EstatusOperacion.EXITOSO);
            this.logger.info("Se hizo el retiro, estatus [{}]", respuesta.getEstatus());

        } catch (Exception e) {
            respuesta.setObjeto(new Saldo());
            respuesta.setEstatus(EstatusOperacion.ERROR);
            this.logger.info("Se hizo la consulta, estatus [{}]", respuesta.getEstatus());
            this.logger.error(e.getMessage(), e);
        }
        return respuesta;
    }

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public BaseRespuestaService<Saldo,EstatusOperacion> transferirSaldo(Modelo modelo){
        logger.info("Transferir saldo");
        BaseRespuestaService<Saldo, EstatusOperacion> respuesta = new BaseRespuestaService<Saldo, EstatusOperacion>();
        try{
        	CuentaEntity cuenta = cuentaDao.obtenerInfoCuentaPorTarjeta(modelo);
        	boolean existeOtraCuenta = cuentaDao.existeNumeroCuenta(modelo.getCampo4());
        	if(!existeOtraCuenta) {
        		logger.info("No existe la cuenta a la que se quiere transferir");
        		
        	}
        	
        }
        catch(Exception e){
            respuesta.setObjeto(new Saldo());
            respuesta.setEstatus(EstatusOperacion.ERROR);
            //Mensaje DE ERROR EN EL OBJETO Respuesta
            this.logger.info("Se hizo la consulta, estatus [{}]", respuesta.getEstatus());
            this.logger.error(e.getMessage(), e);
        }
            
        return respuesta;
    }

}
