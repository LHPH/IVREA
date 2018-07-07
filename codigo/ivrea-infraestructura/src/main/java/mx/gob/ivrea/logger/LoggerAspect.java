package mx.gob.ivrea.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggerAspect {

    Logger log = LoggerFactory.getLogger(TipoLogger.SERVICIOS.name());

    @Autowired
    FormatoLogger formato;

    @Before("execution(* mx.gob.ivrea..*.*(..)) && @annotation(logger) ")
    public void registrar(JoinPoint joinPoint, LoggerAnnotation logger) {

        Object[] args = joinPoint.getArgs();
        String metodo = joinPoint.getSignature().getName();
        String clase = joinPoint.getSignature().getDeclaringType().getSimpleName();
        formato.escEntrada(clase, metodo, logger, args);

    }

    @AfterReturning(value = "execution(* mx.gob.ivrea..*.*(..)) && @annotation(logger) ", returning = "objReturn")
    public void registrarSalida(JoinPoint joinPoint, LoggerAnnotation logger, Object objReturn) {

        String metodo = joinPoint.getSignature().getName();
        String clase = joinPoint.getSignature().getDeclaringType().getSimpleName();
        formato.escSalida(clase, metodo, logger, objReturn);
    }
}
