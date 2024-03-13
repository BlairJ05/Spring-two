package com.example.Events.people;

import com.example.Events.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PeopleConfig {
    @Bean
    CommandLineRunner PeopleCommandLineRunner(
            EventRepository repository){
        return args -> {
            People person = new People(

            );
        };
    };
}
