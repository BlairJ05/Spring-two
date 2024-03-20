package com.example.Events.people;

import com.example.Events.event.Event;
import com.example.Events.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class PeopleConfig {
    @Bean
    CommandLineRunner PeopleCommandLineRunner(
            PeopleRepository peopleRepository){
        return args -> {
            People person = new People(
                    "Blair",
                    "blair@gmail.com",
                    new Event(
                    "PlantDay",
                    "Meri.Farrell@gmail.com",
                    LocalDate.of(2026, Month.JULY, 20)
                            ));
            peopleRepository.save(person);
        };
    }
}
