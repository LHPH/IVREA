package mx.gob.ivrea.cajero.service.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.gob.ivrea.api.entity.ClienteEntity;
import mx.gob.ivrea.api.entity.CuentaEntity;
import mx.gob.ivrea.api.model.Cliente;
import mx.gob.ivrea.api.model.Cuenta;
import mx.gob.ivrea.base.BaseAssembler;
import mx.gob.ivrea.base.BaseHelper;
import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.TipoLogger;

@Component("clienteHelper")
public class ClienteHelper extends BaseHelper implements BaseAssembler<ClienteEntity, Cliente> {

    private Logger logger = LoggerFactory.getLogger(TipoLogger.SERVICIOS.name());

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public Cliente aModel(ClienteEntity entrada) {

        if (entrada != null) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(entrada.getCveCliente());
            cliente.setNombre(noNull(entrada.getNombre()));
            cliente.setDireccion(noNull(entrada.getDireccion()));
            cliente.setCorreo(noNull(entrada.getCorreo()));
            CuentaEntity cuentaEntity = entrada.getCuentas().get(0);
            Cuenta cuenta = new Cuenta();
            cuenta.setNumeroCuenta(noNull(cuentaEntity.getNumeroCuenta()));
            cuenta.setSaldo(String.valueOf(cuentaEntity.getSaldo()));
            cliente.setCuenta(cuenta);
            return cliente;
        }
        return null;
    }
}
