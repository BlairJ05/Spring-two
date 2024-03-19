package com.example.Events.catering;

import com.example.Events.event.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class CateringConfig {
    @Bean
    CommandLineRunner CateringCommandLineRunner(
            CateringRepository cateringRepository){

        return args -> {
            Catering testCatering = new Catering(
                    "mexican",
                    "Mexico"
            );
            cateringRepository.save(testCatering);
        };
    }
}