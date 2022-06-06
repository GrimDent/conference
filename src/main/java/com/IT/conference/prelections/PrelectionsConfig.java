package com.IT.conference.prelections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PrelectionsConfig {
    @Bean
    CommandLineRunner commandLineRunnerPrelections(PrelectionsRepository repository){
        return args -> {
            String[] thematic_paths = {"Backend Stage", "Fronend Stage", "Carrer Stage"};
            String[] start_hour = {"10:00", "12:00", "14:00"};
            String[] title = {"how to write a good API",
                    "Why every backend developer should know SQL?",
                    "Introduction to Spring Boot",
                    "Why your website looks boring?",
                    "React or Angular?",
                    "Color theory",
                    "How to write a good CV",
                    "How to make a good first impression on job interview",
                    "How to build impressive portfolio"};
            List<Prelections> prelections = new ArrayList<>();
            for(int i=0; i<9; i++){
                Prelections prelection = new Prelections();
                prelection.setStart_hour(start_hour[i%3]);
                prelection.setThematic_path(thematic_paths[(i/3)]);
                prelection.setTitle(title[i]);
                prelections.add(prelection);
            }
            repository.saveAll(prelections);
        };
    }
}
