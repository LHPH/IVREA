package mx.gob.ivrea.cajero.service.persistence.interfaces;

import javax.ejb.Local;

import mx.gob.ivrea.api.entity.TarjetaEntity;
import mx.gob.ivrea.api.model.Modelo;

@Local
public interface ClienteLocal {

    TarjetaEntity obtenerClientePorTarjeta(Modelo model);

}
