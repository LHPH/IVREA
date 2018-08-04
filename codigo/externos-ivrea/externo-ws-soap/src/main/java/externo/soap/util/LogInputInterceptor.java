package externo.soap.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogInputInterceptor extends AbstractSoapInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public LogInputInterceptor() {

        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {

        StringBuilder payload = new StringBuilder();
        try {
            InputStream in = message.getContent(InputStream.class);
            if (in != null) {
                CachedOutputStream out = new CachedOutputStream();
                IOUtils.copy(in, out);
                out.flush();
                out.writeCacheTo(payload);
                out.close();
                in.close();
                message.setContent(InputStream.class, out.getInputStream());
            } else {
                payload.append("No disponible");
            }
        } catch (IOException e) {
            logger.error("Error {}", e);
            payload.append("No disponible");
        }

        logger.info("id: {}", message.getId());
        logger.info("Version: {}", message.getVersion().getVersion());
        logger.info("Encoding: {}", message.get(Message.ENCODING));
        logger.info("Http-Method: {}", message.get(Message.HTTP_REQUEST_METHOD));
        logger.info("URL: {}", message.get(Message.REQUEST_URI));
        logger.info("Payload: \n{}", payload);

    }

}
