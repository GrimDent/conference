package com.IT.conference.prelections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

@Configuration
public class PrelectionsConfig {
    @Bean
    CommandLineRunner commandLineRunnerPrelections(PrelectionsRepository repository){
        return args -> {
            Prelections prelection1 = new Prelections(
                    "thematic path 1",
                    "10:00"
            );
            String[] thematic_paths = {"thematic_path1", "thematic_path2", "thematic_path3"};
            String[] start_hour = {"10:00", "12:00", "14:00"};
            List<Prelections> prelections = new ArrayList<>();
            for(int i=0; i<9; i++){
                Prelections prelection = new Prelections();
                prelection.setStart_hour(start_hour[i%3]);
                prelection.setThematic_path(thematic_paths[(i/3)]);
                prelections.add(prelection);
            }
            repository.saveAll(prelections);
        };
    }
}
