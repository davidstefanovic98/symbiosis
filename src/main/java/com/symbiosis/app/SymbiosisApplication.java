package com.symbiosis.app;

import com.symbiosis.app.annotation.Exclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.symbiosis.app")
@EntityScan(basePackages = "com.symbiosis.app")
@ConfigurationPropertiesScan("com.symbiosis.app")
@EnableJpaRepositories(value = "com.symbiosis.app",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Exclude.class))
public class SymbiosisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SymbiosisApplication.class, args);
	}

}
