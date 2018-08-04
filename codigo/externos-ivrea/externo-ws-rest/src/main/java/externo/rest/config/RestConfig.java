package externo.rest.config;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import externo.rest.service.PaymentServices;
import externo.rest.service.impl.PaymentServicesImpl;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class RestConfig {

    @Autowired
    private ApplicationContext applicationContext;

    // Replaces web.xml
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/services/*");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public PaymentServices service() {

        return new PaymentServicesImpl();
    }

    @Bean
    public Server rsServer() {

        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/payments/");
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setServiceBean(service());
        return endpoint.create();
    }

}
