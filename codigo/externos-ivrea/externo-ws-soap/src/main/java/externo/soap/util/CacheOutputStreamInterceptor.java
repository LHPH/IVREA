package externo.soap.util;

import java.io.OutputStream;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class CacheOutputStreamInterceptor extends AbstractPhaseInterceptor<Message> {

    public CacheOutputStreamInterceptor() {

        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(Message message) throws Fault {

        final OutputStream os = message.getContent(OutputStream.class);

        if (os != null && !(os instanceof CachedOutputStream)) {
            final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(os);
            message.setContent(OutputStream.class, newOut);
        }

    }
}
