package com.IT.conference.prelections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PrelectionsConfig {
    @Bean
    CommandLineRunner commandLineRunnerPrelections(PrelectionsRepository repository){
        return args -> {
            Prelections prelection1 = new Prelections(
                    "thematic path 1",
                    "10:00"
            );
            Prelections prelection2 = new Prelections(
                    "thematic path 1",
                    "12:00"
            );
            repository.saveAll(
                    List.of(prelection1, prelection2)
            );
        };
    }
}
