package mx.gob.ivrea.cajero.interfaces;

import javax.ejb.Remote;

import mx.gob.ivrea.api.enums.EstatusOperacion;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.api.model.Saldo;
import mx.gob.ivrea.base.BaseRespuestaService;

@Remote
public interface SaldoRemote {

    BaseRespuestaService<Saldo, EstatusOperacion> consultarSaldo(Modelo modelo);

    BaseRespuestaService<Saldo, EstatusOperacion> depositarSaldo(Modelo modelo);

    BaseRespuestaService<Saldo, EstatusOperacion> retirarSaldo(Modelo modelo);

}
