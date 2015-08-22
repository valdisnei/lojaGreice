package com.lojaGreice.spring.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lojaGreice.spring.dao.UserDAO;
import com.lojaGreice.spring.dao.UserDAOImpl;
import com.lojaGreice.spring.migration.MigrationService;
import com.lojaGreice.spring.migration.MigrationServiceImpl;

@Configuration
@ComponentScan(basePackages="com.lojaGreice.spring")
public class MvcConfiguration extends WebMvcConfigurerAdapter{

//	@Bean
//	public ViewResolver getViewResolver(){
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//	
////	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}

	@Bean
	public UserDAO getUserDao() throws NamingException {
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource = (DataSource) jndiTemplate.lookup("java:jboss/datasources/ExampleDS");
		return new UserDAOImpl(dataSource);
	}
	
	
	@Bean
	public MigrationService MigrationService() throws NamingException {
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource = (DataSource) jndiTemplate.lookup("java:jboss/datasources/ExampleDS");
		return new MigrationServiceImpl(dataSource);
	}
	
	
	
}
