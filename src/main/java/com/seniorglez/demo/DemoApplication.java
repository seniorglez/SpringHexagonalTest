package com.seniorglez.demo;

import com.seniorglez.demo.application.Injectable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		basePackages = "com.seniorglez.demo",
		includeFilters = @ComponentScan.Filter(
				type = FilterType.ANNOTATION,
				classes = Injectable.class
		)
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
