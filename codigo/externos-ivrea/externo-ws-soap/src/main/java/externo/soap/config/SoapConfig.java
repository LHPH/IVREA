package externo.soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import externo.soap.repository.TelefoniaRepository;
import externo.soap.repository.impl.TelefoniaRepositoryImpl;
import externo.soap.service.TelefoniaService;
import externo.soap.service.impl.TelefoniaServiceImpl;
import externo.soap.util.CacheOutputStreamInterceptor;
import externo.soap.util.LogInputInterceptor;
import externo.soap.util.LogOutputInterceptor;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class SoapConfig {

    @Autowired
    private ApplicationContext applicationContext;

    // Replaces web.xml
    @Bean
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/services/*");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public TelefoniaRepository telefoniaRepository() {

        return new TelefoniaRepositoryImpl();
    }

    @Bean
    public TelefoniaService telefoniaService() {

        return new TelefoniaServiceImpl();
    }

    @Bean
    // <jaxws:endpoint id="helloWorld" implementor="demo.spring.service.HelloWorldImpl" address="/HelloWorld"/>
    public EndpointImpl consultaIdentificacionCliente() {

        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        EndpointImpl endpoint = new EndpointImpl(bus, telefoniaService());
        endpoint.publish("/telefonia");
        endpoint.getServer().getEndpoint().getInInterceptors().add(new LogInputInterceptor());
        endpoint.getServer().getEndpoint().getOutInterceptors().add(new CacheOutputStreamInterceptor());
        endpoint.getServer().getEndpoint().getOutInterceptors().add(new LogOutputInterceptor());
        return endpoint;

    }

}
