package mx.gob.ivrea.constants;

public class ConstantsUtils {

    public static final String REQUEST_SCOPE_CONTROLLERS = "request";
    public static final String SESSION_SCOPE_CONTROLLERS = "session";
    public static final String SINGLETON_SCOPE_CONTROLLERS = "singleton";
    public static final String PROTOTYPE_SCOPE_CONTROLLERS = "prototype";
    public static final String GLOBAL_SESSION_SCOPE_CONTROLLERS = "globalSession";

    public static final String TOKEN_RAIZ = "/";
    public static final String TOKEN_REDIRECT = "redirect:";
    public static final String TOKEN_FORWARD = "forward:";

    public static final String REGEX_CONTIENE_MINUSCULAS = ".*[a-z]+.*";
    public static final String REGEX_CONTIENE_MAYUSCULAS = ".*[A-Z]+.*";
    public static final String REGEX_CONTIENE_DIGITOS = ".*[0-9]+.*";
    public static final String REGEX_CARACTERES_ESPECIALES = ".*[!|\"|#|$|%|/|(|)|=|?|¡|'|¿|*|-|+|,|.|;|:|_]+.*";
    public static final String REGEX_CORREO = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    public static final String REGEX_TELEFONO = "[0-9]{10}";
    public static final String REGEX_CLABE = "[0-9]{18}";

    public static final String UNUSED = "unused";
    public static final String UNCHECKED = "unchecked";

    public static final String REPORTE = "reporte";
    public static final String EXTENSION = "extension";
    public static final String CONTENT_TYPE = "content-type";
    public static final String CONTENT_DISPOSITION = "Content-disposition";
    public static final String CONTENT_DISPOSITION_ATTACHMENT = "attachment;filename=";
    public static final String CONTENT_DISPOSITION_INLINE = "inline;filename=";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CACHE_CONTROL_LIFE = "max-age=30";
    public static final String PRAGMA = "Pragma";

    private ConstantsUtils() {

    }

}
