package mx.gob.ivrea.cajero.interfaces;

import javax.ejb.Remote;

import mx.gob.ivrea.api.enums.EstatusOperacion;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.base.BaseRespuestaService;
import mx.gob.ivrea.paginacion.Filtro;

@Remote
public interface MovimientoTarjetaRemote {

    BaseRespuestaService<Filtro, EstatusOperacion> obtenerMovimientos(Modelo modelo);

}
