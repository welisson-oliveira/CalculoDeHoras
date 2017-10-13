package br.com.welisson.calculoDeHoras.config;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SpringBootApplication(scanBasePackages = {"br.com.welisson.calculoDeHoras"})
public class CalculoDeHorasApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

	private final Logger logger = Logger.getLogger(CalculoDeHorasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CalculoDeHorasApplication.class, args);
	}

	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {
			@Override
			public void contextInitialized(final ServletContextEvent paramServletContextEvent) {
				logger.info("Calculo de horas - ServletContext initialized");
			}

			@Override
			public void contextDestroyed(final ServletContextEvent paramServletContextEvent) {
				logger.info("Calculo de horas - ServletContext destroyed");
			}
		};
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringContextConfiguration.class};
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	/** {@inheritDoc} */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
