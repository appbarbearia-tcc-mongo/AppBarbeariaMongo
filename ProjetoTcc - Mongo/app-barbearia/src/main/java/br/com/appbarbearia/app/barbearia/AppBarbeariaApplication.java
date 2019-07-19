package br.com.appbarbearia.app.barbearia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages= "br.com.appbarbearia.*")
public class AppBarbeariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBarbeariaApplication.class, args);
	}

}
