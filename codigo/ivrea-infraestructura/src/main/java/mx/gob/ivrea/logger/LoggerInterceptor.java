package mx.gob.ivrea.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggerInterceptor {

    @AroundInvoke
    public Object registrarLogger(InvocationContext ctx) throws Exception {

        FormatoLogger formato = new FormatoLogger();

        String clase = ctx.getMethod().getDeclaringClass().getName();
        String metodo = ctx.getMethod().getName();
        LoggerAnnotation anotacion = ctx.getMethod().getAnnotation(LoggerAnnotation.class);
        Object[] args = ctx.getParameters();
        try {
            formato.escEntrada(clase, metodo, anotacion, args);
            Object obj = ctx.proceed();
            formato.escSalida(clase, metodo, anotacion, obj);
            return obj;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
