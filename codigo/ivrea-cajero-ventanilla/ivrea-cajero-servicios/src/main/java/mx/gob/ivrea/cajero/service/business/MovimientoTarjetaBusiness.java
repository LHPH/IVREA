package mx.gob.ivrea.cajero.service.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import mx.gob.ivrea.api.constants.ParametrosConstants;
import mx.gob.ivrea.api.enums.EstatusOperacion;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.base.BaseBusinessService;
import mx.gob.ivrea.base.BaseRespuestaService;
import mx.gob.ivrea.cajero.interfaces.MovimientoTarjetaRemote;
import mx.gob.ivrea.cajero.service.persistence.interfaces.MovimientoTarjetaLocal;
import mx.gob.ivrea.paginacion.ConstantsPagination;
import mx.gob.ivrea.paginacion.Filtro;
import mx.gob.ivrea.paginacion.Restriccion;

@Stateless(name = "movimientoTarjetaBusiness", mappedName = "movimientoTarjetaBusiness")
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class MovimientoTarjetaBusiness extends BaseBusinessService implements MovimientoTarjetaRemote {

    @EJB
    MovimientoTarjetaLocal movimientoTarjetaDao;

    @Override
    public BaseRespuestaService<Filtro, EstatusOperacion> obtenerMovimientos(Modelo modelo) {

        this.logger.info("Consultando movimientos de la tarjeta");
        BaseRespuestaService<Filtro, EstatusOperacion> respuesta = new BaseRespuestaService<Filtro, EstatusOperacion>();
        try {
            Filtro filtro = new Filtro();
            filtro.setPaginaActual(Integer.parseInt(modelo.getCampo2()));
            filtro.setTamanoPagina(ConstantsPagination.DEFAULT_TAM_PAGINA);
            List<Restriccion> restricciones = new ArrayList<Restriccion>();
            Restriccion rest = new Restriccion();
            rest.setNomParametro(ParametrosConstants.PARAM_SQL_NUM_TARJETA);
            rest.setValor(modelo.getCampo1()); // Num Tarjeta
            restricciones.add(rest);
            filtro.setRestricciones(restricciones);

            Filtro nuevo = movimientoTarjetaDao.obtenerMovimientos(filtro);
            this.logger.info("Se han consultado de la BD los movimientos de la tarjeta");
            EstatusOperacion estatus = EstatusOperacion.EXITOSO;
            respuesta.setEstatus(estatus);
            respuesta.setObjeto(nuevo);
        } catch (Exception e) {
            this.logger.debug(e.getMessage(), e);
            respuesta.setEstatus(EstatusOperacion.ERROR);
            respuesta.setObjeto(new Filtro(0, 0, 0));
        }
        return respuesta;
    }

}
