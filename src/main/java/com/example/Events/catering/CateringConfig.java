package com.example.Events.catering;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class CateringConfig {
    @Bean
    CommandLineRunner CateringCommandLineRunner(
            CateringRepository cateringRepository){

        return args -> {
            Catering testCatering = new Catering(
                    "mexican",
                    "Mexico");
            cateringRepository.save(testCatering);
        };
    }
}