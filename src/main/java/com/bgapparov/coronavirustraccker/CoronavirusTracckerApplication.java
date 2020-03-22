package com.bgapparov.coronavirustraccker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusTracckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusTracckerApplication.class, args);
	}

}
