package rs.prati.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("rs.prati.core")
@EnableJpaRepositories(basePackages = "rs.prati.service.repository")
@SpringBootApplication(scanBasePackages = {
	    "rs.prati.rest",        // REST контролери и конфигурација
	    "rs.prati.service"      // сервисни слој и репозиторијуми
	})
public class MainRestApp {

    public static void main(String[] args) {
        SpringApplication.run(MainRestApp.class, args);
    }
}
