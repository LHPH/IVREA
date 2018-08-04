package externo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.ws.config.annotation.EnableWs;

import externo.rest.config.RestConfig;

@SpringBootApplication
@EnableWs
@Import(RestConfig.class)
public class ExternoRestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(ExternoRestApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(ExternoRestApplication.class);
    }

}
