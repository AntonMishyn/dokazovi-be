package com.softserveinc.dokazovi;

import com.softserveinc.dokazovi.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DokazoviApplication {

	public static void main(String[] args) {
		SpringApplication.run(DokazoviApplication.class, args);
	}

}