package com.IT.conference.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository){
        return args -> {
            Users user1 = new Users(
                    "sampleLogin",
                    "sample.mail@gmail.com"
            );
            Users user2 = new Users(
                    "anotherLogin",
                    "another.mail@gmail.com"
            );

            repository.saveAll(
                    List.of(user1, user2)
            );
        };
    }
}
