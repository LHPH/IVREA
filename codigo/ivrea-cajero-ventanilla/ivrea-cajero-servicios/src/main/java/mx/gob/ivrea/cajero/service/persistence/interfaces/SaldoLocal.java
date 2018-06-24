package mx.gob.ivrea.cajero.service.persistence.interfaces;

import javax.ejb.Local;

import mx.gob.ivrea.api.entity.CuentaEntity;
import mx.gob.ivrea.api.model.Modelo;

@Local
public interface SaldoLocal {

    CuentaEntity obtenerInfoCuenta(Modelo modelo);

    void actualizarCuenta(CuentaEntity cuenta);

}
