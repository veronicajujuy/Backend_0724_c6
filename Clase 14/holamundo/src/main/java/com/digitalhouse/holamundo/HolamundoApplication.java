package com.digitalhouse.holamundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
@SpringBootApplication
public class HolamundoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HolamundoApplication.class, args);
	}

	@GetMapping("/hola")
	public String holaMundo(){
		return "Hola Mundo desde springboot";
	}

	@GetMapping("/chau")
	public String chauMundo(){
		return "Adios !!";
	}
}
