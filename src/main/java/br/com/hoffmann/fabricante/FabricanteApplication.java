package br.com.hoffmann.fabricante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class FabricanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricanteApplication.class, args);
	}

}
