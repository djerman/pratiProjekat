package rs.prati.rest.controller;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import rs.prati.service.common.MessageService;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    MessageService messageService() {
        return mock(MessageService.class);
    }
}
