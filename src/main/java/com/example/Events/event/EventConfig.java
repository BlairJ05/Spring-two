package com.example.Events.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;


@Configuration
public class EventConfig {

    @Bean
    CommandLineRunner EventCommandLineRunner(
            EventRepository eventRepository){

        return args -> {
            Event MerisEvent = new Event(
                    "PlantDay",
                    "Meri.Farrell@gmail.com",
                    LocalDate.of(2026, Month.JULY, 20)
                    );
            eventRepository.save(MerisEvent);
        };
    }
}