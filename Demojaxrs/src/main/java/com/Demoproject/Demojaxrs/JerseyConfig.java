package com.Demoproject.Demojaxrs;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(JacksonFeature.class);
        register(RequestContextFilter.class);
        packages("net.equj65.rest");
      //  register(LoggingFilter.class);

    }

}
