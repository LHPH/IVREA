package mx.gob.ivrea.cajero.validador;

import java.util.regex.Pattern; 

import org.springframework.stereotype.Component;

import mx.gob.ivrea.api.constants.ExpRegularesIvrea;
import mx.gob.ivrea.api.model.Modelo;

@Component
public class ValidadorCampos{

    public boolean validarDatosDepositar(Modelo modelo){
        String deposito = modelo.getCampo2();
        if(Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES, deposito)){
            return true;
        }
        return false;
    }

    public boolean validarDatosRetiro(Modelo modelo){
        String retiro = modelo.getCampo2();
        if(Pattern.matches(ExpRegularesIvrea.EXP_REG_NUMEROS_DECIMALES,retiro)){
            return true;
        }
        return true;
    }

}