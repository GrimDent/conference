package com.IT.conference.users;

import com.IT.conference.prelections.Prelections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunnerUsers(UsersRepository repository){
        return args -> {
            List<Users> users = new ArrayList<>();
            Users user1 = new Users(
                    "Philip123",
                    "philip123@gmail.com"
            );
            users.add(user1);
            Users user2 = new Users(
                    "Alice387",
                    "alice387@gmail.com"
            );
            users.add(user2);
            Users user3 = new Users(
                    "Bob777",
                    "bob777@gmail.com"
            );
            users.add(user3);
            repository.saveAll(users);

        };
    }
}
