package externo.soap.util;

import java.io.OutputStream;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogOutputInterceptor extends AbstractSoapInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public LogOutputInterceptor() {

        super(Phase.SEND);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {

        StringBuilder payload = new StringBuilder();

        try {
            OutputStream out = message.getContent(OutputStream.class);
            if (out != null && (out instanceof CachedOutputStream)) {

                CachedOutputStream nuevoOut = (CachedOutputStream) out;
                nuevoOut.writeCacheTo(payload);
                nuevoOut.flush();
                nuevoOut.close();
                out.close();
            } else {
                payload.append("No disponible");
            }
        } catch (Exception e) {
            logger.error("Error {}", e);
            payload.append("No disponible");
        }

        logger.info("Version: {}", message.getVersion().getVersion());
        logger.info("Encoding: {}", message.get(Message.ENCODING));
        logger.info("Payload: {}", payload);

    }

}
