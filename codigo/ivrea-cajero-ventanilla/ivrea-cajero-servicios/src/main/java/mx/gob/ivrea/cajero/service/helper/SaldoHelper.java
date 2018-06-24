package mx.gob.ivrea.cajero.service.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.gob.ivrea.api.entity.CuentaEntity;
import mx.gob.ivrea.api.model.Saldo;
import mx.gob.ivrea.base.BaseHelper;
import mx.gob.ivrea.base.BaseAssembler;
import mx.gob.ivrea.base.BaseModel;
import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.TipoLogger;

@Component("saldoHelper")
public class SaldoHelper extends BaseHelper implements BaseAssembler<CuentaEntity, Saldo> {

    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.SERVICIOS)
    public Saldo aModel(CuentaEntity entrada) {

        Saldo saldo = new Saldo();
        saldo.setCuenta(entrada.getNumeroCuenta());
        saldo.setSaldo(entrada.getSaldo());
        return saldo;
    }

    // @Override
    public Saldo aModel(List<? extends BaseModel> entradas) {

        // TODO Auto-generated method stub
        return null;
    }

}
