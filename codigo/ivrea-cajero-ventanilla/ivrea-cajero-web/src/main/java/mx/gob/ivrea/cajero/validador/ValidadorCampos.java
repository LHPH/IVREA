package mx.gob.ivrea.cajero.validador;

import java.util.regex.Pattern; 

import org.springframework.stereotype.Component;

import mx.gob.ivrea.api.constants.ExpRegularesIvrea;
import mx.gob.ivrea.api.constants.ParametrosConstants;

import javax.servlet.http.HttpServletRequest;

@Component
public class ValidadorCampos{

    public boolean validarDatosDepositar(HttpServletRequest request){
        String campoSaldoDepositar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
        String campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);

        int cont=0;

        if(Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES, campoSaldoDepositar)){
            cont++;
        }

        if(Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoDisponible)){
            cont++;
        }

        if(cont==0){
            return true;
        }
        return false;
    }

    public boolean validarDatosRetiro(HttpServletRequest request){
        String campoSaldoRetirar = request.getParameter(ParametrosConstants.CAMPO_CANTIDAD);
        String campoSaldoDisponible = request.getParameter(ParametrosConstants.CAMPO_SALDO);

        int cont = 0;
        if(Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoRetirar)){
            cont++;
        }

        if(Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,campoSaldoDisponible)){
            cont++;
        }

        if(cont==0){
            return true;
        }
        return false;
    }

}