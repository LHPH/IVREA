package mx.gob.ivrea.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.ivrea.logger.TipoLogger;

public class BaseBusinessService extends BaseApplication {

    protected Logger logger = LoggerFactory.getLogger(TipoLogger.SERVICIOS.toString());
}
