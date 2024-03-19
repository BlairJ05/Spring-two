package com.example.Events.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


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
//            Event CecilysEvent = new Event(
//                    "Birthday",
//                    "Cecily.Scott@gmail.com",
//                    LocalDate.of(2024, Month.JUNE, 13)
//            );
//            Event JohnsEvent = new Event(
//                    "Anniversary",
//                    "John.Joe@gmail.com",
//                    LocalDate.of(2025, Month.FEBRUARY, 1)
//
//
//            );
            eventRepository.save(MerisEvent);
        };
    };
}
