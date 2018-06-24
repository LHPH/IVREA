package mx.gob.ivrea.cajero.service.persistence.interfaces;

import javax.ejb.Local;

import mx.gob.ivrea.paginacion.Filtro;

@Local
public interface MovimientoTarjetaLocal {

    public Filtro obtenerMovimientos(Filtro filtro);

    public int obtenerTotalMovimientos(Filtro filtro);

}
