package mx.gob.ivrea.base;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class BaseApplication {

    /**
     * @param valor
     *            el valor del string
     * @return regresa cadena vacia si es null y el valor original si no es null.
     */
    public String noNull(String valor) {

        return valor == null ? "" : valor;
    }

    /**
     * @param valor:
     *            el valor del string
     * @return true si es null, false en otro caso.
     */
    public boolean esNull(String valor) {

        return valor == null ? true : false;
    }

    /**
     * Metodo para verificar y evitar que un determinado objeto sea null. En caso de ser null
     * se tratara de crear una instancia de ese determinado objeto, sin embargo, no hay
     * garantia de que tal operacion pueda llevarse acabo. Hay varias razones por las cuales
     * no se pueda crear una instancia de ese objeto, la principal es que la clase no tenga
     * un constructor sin argumentos y publico. Si la clase es una interfaz o es una clase
     * abstracta o una clase interna, este metodo fallará seguramente.
     * En caso de que no se pueda crear la instancia, no queda mas que volver a lo seguro
     * e.g
     * Animal animal2 = animal==null?new Animal():animal;
     * 
     * @param obj
     *            Un objeto que debe heredar de BaseModel
     * @param clase
     *            La clase del objeto
     * @return una nueva instancia del objeto o el objeto mismo si no es null
     * @throws InstantiationException
     *             si no se puede instanciar el objeto
     * @throws IllegalAccessException
     */
    public <T extends BaseModel> T objetoNoNull(BaseModel obj, Class<T> clase)
            throws InstantiationException, IllegalAccessException {

        return clase.cast((obj == null ? clase.newInstance() : obj));
    }

    /**
     * @param fecha:
     *            La fecha de tipo Date
     * @param mask:
     *            la mascara de la fecha, e.g DD/MM/YYYY
     * @return una representacion de tipo String de la fecha
     */
    public String convertirDate(Date fecha, String mask) {

        SimpleDateFormat sd = new SimpleDateFormat(mask, new Locale("es", "MX"));
        return sd.format(fecha);
    }

    /**
     * @param fecha:
     *            Una representacion textual de la fecha
     * @return la fecha de tipo Date
     * @throws ParseException
     *             si no se puede parsear la fecha de String a Date
     */
    public Date convertirString(String fecha) throws ParseException {

        DateFormat df = DateFormat.getDateInstance();
        return df.parse(fecha);
    }

    /**
     * @param texto:
     *            El texto a convertir a formato camello, e.g Instituto Del Seguro Social.
     * @return el texto ya transformado a formato camello o cadena vacia si texto es cadena vacia o null
     */
    public String textoFormatoCamello(String texto) {

        if (texto != null && !texto.isEmpty()) {
            String cadena = texto.toLowerCase();
            String[] trozos = cadena.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int cont = 0; cont < trozos.length; cont++) {
                builder.append(trozos[cont].toUpperCase().substring(0, 1).concat(trozos[cont].substring(1)));
                if (cont + 1 != trozos.length) {
                    builder.append(" ");
                }
            }
            return builder.toString();
        } else {
            return "";
        }
    }

    /**
     * @param texto:
     *            El texto a formatear
     * @return el texto con la primera letra de la primera palabra en mayuscula o cadena vacia si es
     */
    public String textoPrimeraCapital(String texto) {

        if (texto != null && !texto.isEmpty()) {
            return texto.toUpperCase().substring(1, 0).concat(texto.substring(1).toLowerCase());
        } else {
            return "";
        }
    }

    /**
     * @param num:
     *            El numero a transformar
     * @param mask:
     *            la mascara para la representacion del numero en texto
     * @return el numero transformado a String con la respresentacion indicada
     */
    public String formatoDecimal(Double num, String mask) {

        DecimalFormat dec = new DecimalFormat(mask);
        return dec.format(num);
    }

    public Map<String, String> obtenerPropiedades(String nombreArchivo) throws IOException {

        Properties props = new Properties();
        props.load(ClassLoader.getSystemResourceAsStream(nombreArchivo));
        Enumeration<Object> keys = props.keys();
        Map<String, String> param = new HashMap<String, String>();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement().toString();
            param.put(key, props.get(key).toString());
        }
        return param;
    }

}
