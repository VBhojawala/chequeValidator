package com.validator;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.validator.*")
@EntityScan("com.validator.*")
@EnableJpaRepositories("com.validator.*")
@SpringBootApplication
@Log4j2
public class ChequeConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChequeConsumerApplication.class, args);
    }
}
