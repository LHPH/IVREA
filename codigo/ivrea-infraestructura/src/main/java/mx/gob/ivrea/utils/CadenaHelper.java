package mx.gob.ivrea.utils;

import org.springframework.stereotype.Component;

import mx.gob.ivrea.base.BaseHelper;

@Component("cadenaHelper")
public class CadenaHelper extends BaseHelper {

    public String unirSubcadenas(String... args) {

        if (args != null) {
            return unirSubCadenasConDelimitador(",", args);
        } else {
            return "";
        }
    }

    public String unirSubCadenasConDelimitador(String delimitador, String... args) {

        if (args != null && delimitador != null) {
            StringBuilder cadena = new StringBuilder();
            int num = args.length;
            for (int cont = 0; cont < num; cont++) {
                if ((cont + 1) == num) {
                    cadena.append(args[cont]);
                } else {
                    cadena.append(args[cont]);
                    cadena.append(delimitador);
                }
            }
            return cadena.toString();
        } else {
            return "";
        }
    }

}
