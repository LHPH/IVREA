package externo.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.ws.config.annotation.EnableWs;

import externo.soap.config.SoapConfig;

@SpringBootApplication
@EnableWs
@Import(SoapConfig.class)
public class ExternoSoapApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(ExternoSoapApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(ExternoSoapApplication.class);
    }

}
