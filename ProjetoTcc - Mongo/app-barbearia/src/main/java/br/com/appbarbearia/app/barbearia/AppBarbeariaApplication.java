package br.com.appbarbearia.app.barbearia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import br.com.appbarbearia.model.Role;
import br.com.appbarbearia.repository.RoleRepository;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages= "br.com.appbarbearia.*")
public class AppBarbeariaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AppBarbeariaApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppBarbeariaApplication.class);
	}
	
	@Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            Role adminRole = roleRepository.findByName("CLIENTE");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setName("CLIENTE");
                roleRepository.save(newAdminRole);
            }
            
            Role userRole = roleRepository.findByName("BARBEIRO");
            if (userRole == null) {
                Role newUserRole = new Role();
                newUserRole.setName("BARBEIRO");
                roleRepository.save(newUserRole);
            }

        };

    }

}
