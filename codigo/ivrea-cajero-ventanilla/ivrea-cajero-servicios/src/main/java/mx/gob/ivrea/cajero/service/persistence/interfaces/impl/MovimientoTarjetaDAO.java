package mx.gob.ivrea.cajero.service.persistence.interfaces.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import mx.gob.ivrea.api.constants.ParametrosConstants;
import mx.gob.ivrea.api.constants.SQLConstants;
import mx.gob.ivrea.api.model.MovimientoTarjeta;
import mx.gob.ivrea.base.BaseAssembler;
import mx.gob.ivrea.base.BasePersistence;
import mx.gob.ivrea.cajero.service.persistence.interfaces.MovimientoTarjetaLocal;
import mx.gob.ivrea.paginacion.Filtro;
import mx.gob.ivrea.paginacion.Restriccion;

import mx.gob.ivrea.logger.Categoria;
import mx.gob.ivrea.logger.LoggerAnnotation;
import mx.gob.ivrea.logger.LoggerInterceptor;
import mx.gob.ivrea.logger.TipoLogger;

@Stateless(name = "movimientoTarjetaDao", mappedName = "movimientoTarjetaDao")
@Interceptors({ SpringBeanAutowiringInterceptor.class,LoggerInterceptor.class })
public class MovimientoTarjetaDAO extends BasePersistence implements MovimientoTarjetaLocal {

    @Autowired
    @Qualifier("movimientoTarjetaHelper")
    BaseAssembler<List<Object[]>, List<MovimientoTarjeta>> movimientoTarjetaHelper;

    @SuppressWarnings("unchecked")
    @Override
    @LoggerAnnotation(categoria = Categoria.INFO, tipo = TipoLogger.PERSISTENCIA)
    public Filtro obtenerMovimientos(Filtro filtro) {

        SQLQuery query = this.getSession().createSQLQuery(SQLConstants.CONSULTA_MOVIMIENTOS_TARJETA);

        int maxResults = obtenerTotalMovimientos(filtro);
        long totalPaginas = filtro.obtenerTotalPaginas(maxResults);
        long pagActual = filtro.getPaginaActual();
        long pagTamano = filtro.getTamanoPagina();
        int indice = (int) ((pagActual * pagTamano) - pagTamano);
        int totalRegistros = 0;
        List<Object[]> lista = null;
        List<Restriccion> restricciones = filtro.getRestricciones();

        logger.info("Inicio {}",indice);
        logger.info("Fin {}",filtro.getTamanoPagina());

        query.setFirstResult(indice);
        query.setMaxResults(filtro.getTamanoPagina());
        query.setParameter(ParametrosConstants.PARAM_SQL_NUM_TARJETA, restricciones.get(0).getValor());

        if (maxResults > 0) {
            lista = query.list();
            logger.info("Registros obtenidos: [{}]",lista==null?0:lista.size());
            totalRegistros = lista.size();
        }
        logger.info("Total registros: [{}]",totalRegistros);
        logger.info("Total Paginas: [{}]",totalPaginas);
        logger.info("Pagina actual: [{}]",pagActual);

        Filtro nuevo = new Filtro(totalRegistros, totalPaginas, pagActual);
        nuevo.setDatos(movimientoTarjetaHelper.aModel(lista));

        return nuevo;

    }

    @Override
    public int obtenerTotalMovimientos(Filtro filtro) {

        SQLQuery query = this.getSession().createSQLQuery(SQLConstants.CONSULTA_NUM_TOTAL_MOVIMIENTOS_TARJETA);
        List<Restriccion> restricciones = filtro.getRestricciones();
        query.setParameter(ParametrosConstants.PARAM_SQL_NUM_TARJETA, restricciones.get(0).getValor());
        logger.info("Registros recuperados: [{}] ",query.uniqueResult());
        Long total = Long.parseLong(query.uniqueResult().toString());
        return total.intValue();
    }

}
