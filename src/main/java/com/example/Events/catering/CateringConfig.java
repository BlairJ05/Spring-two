package com.example.Events.catering;

import com.example.Events.event.Event;
import com.example.Events.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CateringConfig {
        @Bean
        CommandLineRunner CateringCommandLineRunner(
                EventRepository repository){
            return args -> {
                Catering catering = new Catering(

                );
            };
        }
}

