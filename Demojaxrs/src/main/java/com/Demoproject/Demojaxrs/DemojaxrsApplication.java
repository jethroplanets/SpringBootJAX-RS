package com.Demoproject.Demojaxrs;

import com.Demoproject.Demojaxrs.model.Item;
import com.Demoproject.Demojaxrs.repository.ItemRepository;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemojaxrsApplication implements CommandLineRunner {

	@Autowired
	ItemRepository itemrepository;

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean servletBean = new ServletRegistrationBean(
				new ServletContainer(), "/*");
		servletBean.addInitParameter(
				ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return servletBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemojaxrsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		itemrepository.save(new Item(39,"Electronic Systems & Lighting"));
		itemrepository.save(new Item(40, "Distribution & Conditioning Systems"));
		itemrepository.save(new Item(27, "Tools & General Machinery"));
		itemrepository.save(new Item(32, "Electronic Components & Supplies"));

	}
}
