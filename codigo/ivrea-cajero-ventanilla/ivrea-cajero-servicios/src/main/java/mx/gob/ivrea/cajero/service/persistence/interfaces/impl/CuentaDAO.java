package mx.gob.ivrea.cajero.service.persistence.interfaces.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.hibernate.SQLQuery;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import mx.gob.ivrea.api.entity.CuentaEntity;
import mx.gob.ivrea.api.entity.TarjetaEntity;
import mx.gob.ivrea.api.enums.EstadoTarjeta;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.api.constants.ParametrosConstants;
import mx.gob.ivrea.api.constants.SQLConstants;
import mx.gob.ivrea.base.BasePersistence;
import mx.gob.ivrea.cajero.service.persistence.interfaces.CuentaLocal;
import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.LoggerInterceptor;
import mx.gob.ivrea.logger.TipoLogger;

@Stateless(name = "cuentaDao")
@Interceptors({ LoggerInterceptor.class })
public class CuentaDAO extends BasePersistence implements CuentaLocal {

    private Criteria criteria;

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.PERSISTENCIA)
    public CuentaEntity obtenerInfoCuentaPorTarjeta(Modelo modelo) {

        String numTarjeta = modelo.getCampo1();
        criteria = this.getSession().createCriteria(TarjetaEntity.class);
        criteria.add(Restrictions.eq("numeroTarjeta", numTarjeta));
        criteria.add(Restrictions.eq("activa", EstadoTarjeta.ACTIVA.getValor()));
        TarjetaEntity tarjeta = (TarjetaEntity) criteria.uniqueResult();
        return tarjeta.getCuenta();
    }

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.PERSISTENCIA)
    public CuentaEntity obtenerInfoCuentaPorNumeroCuenta(Modelo modelo){
        String numeroCuenta = modelo.getCampo1();
        criteria = this.getSession().createCriteria(CuentaEntity.class);
        criteria.add(Restrictions.eq("numeroCuenta", numeroCuenta));
        return (CuentaEntity)criteria.uniqueResult();
    }

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.PERSISTENCIA)
    public void actualizarCuenta(CuentaEntity cuenta) {

        this.getSession().saveOrUpdate(cuenta);
        this.getSession().flush();
    }

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.PERSISTENCIA)
    public boolean existeNumeroCuenta(String cuenta){
        SQLQuery query = this.getSession().createSQLQuery(SQLConstants.CONSULTA_EXISTE_NUMERO_CUENTA);
        query.setParameter(ParametrosConstants.PARAM_SQL_NUM_CUENTA,cuenta);
        List list=query.list();
        Object obj=list.get(0);
        int num=Integer.parseInt(obj.toString());
        return num==0?false:true;
    }

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.PERSISTENCIA)
    public boolean existeNumeroTarjeta(String tarjeta){
        SQLQuery query = this.getSession().createSQLQuery(SQLConstants.CONSULTA_EXISTE_NUMERO_TARJETA);
        query.setParameter(ParametrosConstants.PARAM_SQL_NUM_TARJETA, tarjeta);
        List list=query.list();
        Object obj=list.get(0);
        int num=Integer.parseInt(obj.toString());
        return num==0?false:true;
    }

}