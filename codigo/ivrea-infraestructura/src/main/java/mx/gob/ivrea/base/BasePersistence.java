package mx.gob.ivrea.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.ivrea.logger.TipoLogger;

public class BasePersistence extends BaseApplication {

    protected Logger logger = LoggerFactory.getLogger(TipoLogger.PERSISTENCIA.toString());

    @PersistenceContext(unitName = "IvreaPersistence")
    EntityManager entity;

    public Session getSession() {

        // Para trabajar con weblogic y crear un Session de Hibernate
        return (Session) entity.getDelegate();
    }

    public EntityManager getEntity() {

        return entity;
    }

}
