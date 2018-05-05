package com.portofinolabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.portofinolabs.model.parser")
@ComponentScan("com.portofinolabs.model.converter")
@ComponentScan(basePackageClasses = HelloWorldController.class)
public class PortofinoLabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortofinoLabsApplication.class, args);
	}
}
