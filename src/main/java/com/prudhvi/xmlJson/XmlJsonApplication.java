package com.prudhvi.xmlJson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Ticket API",
				version = "1.0",
				description = "API documentation for booking ticket"
		)
)
@SpringBootApplication
public class XmlJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlJsonApplication.class, args);
	}

}
