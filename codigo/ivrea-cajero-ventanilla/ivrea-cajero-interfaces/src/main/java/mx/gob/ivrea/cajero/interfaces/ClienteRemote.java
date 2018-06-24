package mx.gob.ivrea.cajero.interfaces;

import javax.ejb.Remote;

import mx.gob.ivrea.api.model.Cliente;
import mx.gob.ivrea.api.model.Modelo;

@Remote
public interface ClienteRemote {

    Cliente obtenerCliente(Modelo modelo);

}
