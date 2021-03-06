package com.iist.register;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}

	@Bean
	public SpringLiquibase liquibase(DataSource dataSource) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:db/changelog/master.xml");
		liquibase.setDataSource(dataSource);
		return liquibase;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*");
			}
		};
	}
}
