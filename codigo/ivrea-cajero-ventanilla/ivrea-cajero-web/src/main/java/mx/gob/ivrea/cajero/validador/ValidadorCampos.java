package mx.gob.ivrea.cajero.validador;

import java.util.regex.Pattern; 

import org.springframework.stereotype.Component;

import mx.gob.ivrea.api.constants.ExpRegularesIvrea;
import mx.gob.ivrea.api.constants.ParametrosConstants;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.ivrea.logger.TipoLogger;

@Component
public class ValidadorCampos{

    Logger logger = LoggerFactory.getLogger(TipoLogger.VISTA.toString());

    public boolean validarDatosDepositar(HttpServletRequest request){
        String campoSaldoDepositar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
        String campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);

        int cont=0;
        logger.info("Validando datos a depositar {} {}",campoSaldoDepositar,campoSaldoDisponible);
        if(!Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES, campoSaldoDepositar)){
            cont++;
        }
        if(!Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoDisponible)){
            cont++;
        }
        logger.info("Resultado de la validacion {}",cont);
        if(cont==0){
            return true;
        }
        return false;
    }

    public boolean validarDatosRetiro(HttpServletRequest request){
        String campoSaldoRetirar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
        String campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);

        int cont = 0;
        logger.info("Validando datos de retirar {} {}",campoSaldoRetirar,campoSaldoDisponible);
        if(!Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoRetirar)){
            cont++;
        }

        if(!Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoDisponible)){
            cont++;
        }
        logger.info("Resultado de la validacion {}",cont);
        if(cont==0){
            return true;
        }
        return false;
    }

    public boolean validarDatosTransferencia(HttpServletRequest request){
        String campoSaldoDepositar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
        String campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);
        String campoOtraCuenta = request.getParameter(ParametrosConstants.CAMPO_OTRA_CUENTA);

        int cont=0;
        logger.info("Validando datos de retirar {} {}",campoSaldoDepositar,campoOtraCuenta);
        if(!Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoDepositar)){
            cont++;
        }

        if(!Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoDisponible)){
            cont++;
        }

        if(!Pattern.matches(ExpRegularesIvrea.EXP_REG_NUM_CUENTA_IVREA,campoOtraCuenta)){
            cont++;
        }

        logger.info("Resultado de la validacion {}",cont);
        if(cont==0){
            return true;
        }
        return false;
    }

}