package mx.gob.ivrea.cajero.service.persistence.interfaces.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import mx.gob.ivrea.api.entity.TarjetaEntity;
import mx.gob.ivrea.api.enums.EstadoTarjeta;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.base.BasePersistence;
import mx.gob.ivrea.cajero.service.persistence.interfaces.ClienteLocal;

import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.LoggerInterceptor;
import mx.gob.ivrea.logger.TipoLogger;

@Stateless(name = "clienteDao")
@Interceptors({ LoggerInterceptor.class })
public class ClienteDAO extends BasePersistence implements ClienteLocal {

    Criteria criteria;

    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.PERSISTENCIA)
    public TarjetaEntity obtenerClientePorTarjeta(Modelo model) {

        this.logger.debug("Obteniendo el cliente desde BD");
        String numTarjeta = model.getCampo1();
        String nip = model.getCampo2();
        criteria = this.getSession().createCriteria(TarjetaEntity.class);
        criteria.add(Restrictions.eq("numeroTarjeta", numTarjeta));
        criteria.add(Restrictions.eq("nip", nip));
        criteria.add(Restrictions.eq("activa", EstadoTarjeta.ACTIVA.getValor()));
        TarjetaEntity tarjeta = (TarjetaEntity) criteria.uniqueResult();
        return tarjeta;
    }

}
