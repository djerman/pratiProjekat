package rs.prati.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	    "rs.prati.rest",        // REST контролери и конфигурација
	    "rs.prati.service"      // сервисни слој и репозиторијуми
	})
public class MainRestApp {

    public static void main(String[] args) {
        SpringApplication.run(MainRestApp.class, args);
    }
}
