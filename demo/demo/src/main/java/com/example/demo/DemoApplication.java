package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//here we add package explicitly for scanning
//because @component scan only base package not other packages
//it is necessary to list all packages
@SpringBootApplication(
		scanBasePackages = {"com.example.demo","com.example.util"}
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
