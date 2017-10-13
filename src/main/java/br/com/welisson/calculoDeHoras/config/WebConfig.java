package br.com.welisson.calculoDeHoras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;

/**
 * Class responsible to handle requests to/from spring.
 *
 * @author Welisson Oliveira
 * @version 1.0 07/02/2017
 */

@Order(3)
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true);
        builder.dateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        return builder;
    }
    
    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                  .ignoreAcceptHeader(true)
                  .parameterName("mediaType")
                  .useJaf(false)
                  .defaultContentType(MediaType.APPLICATION_JSON)
                  .mediaType("xml", MediaType.APPLICATION_XML)
                  .mediaType("json", MediaType.APPLICATION_JSON);
    }
    
}
