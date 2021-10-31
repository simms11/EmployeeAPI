package com.springbootpostgressdocker.springbootpostgressdocker;

import model.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")

public class SpringbootPostgressDockerApplication {

	@Bean
	public AuditorAware<String>auditorAware(){return new AuditorAwareImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootPostgressDockerApplication.class, args);
	}

}
