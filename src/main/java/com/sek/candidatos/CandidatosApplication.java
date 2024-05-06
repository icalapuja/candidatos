package com.sek.candidatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.sek.candidatos")
@SpringBootApplication
public class CandidatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatosApplication.class, args);
	}

}
