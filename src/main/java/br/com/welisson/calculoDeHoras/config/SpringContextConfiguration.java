/*
 * @(#)SpringContextConfiguration.java 1.0 31/03/2017
 *
 * Copyright (c) 2016, Embraer. All rights reserved.
 * Embraer S/A proprietary/confidential. Use is subject to license terms.
 */

package br.com.welisson.calculoDeHoras.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * A classe <code>SpringContextConfiguration</code> representa a configuracao do
 * contexto do Spring da aplicacao.
 *
 * @author Welisson Oliveira
 * @version 1.0 31/03/2017
 */
@Configuration
@ComponentScan("br.com.welisson.calculoDeHoras")
public class SpringContextConfiguration {
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Validator validator() {
		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
