package com.api.medfacil;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "MedFácil API"
				, description = "Api para gestão de medicamentos"
				, version = "1"
				, contact = @Contact(name = "João Paulo", email = "jp.sport17@gmail.com")
		)
)
public class MedfacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedfacilApplication.class, args);
	}

}
