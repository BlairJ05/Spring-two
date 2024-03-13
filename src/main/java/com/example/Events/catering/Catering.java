package com.example.Events.catering;

import com.example.Events.event.Event;
import com.example.Events.people.People;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class Catering {

        @Id
        @SequenceGenerator(
                name = "catering_sequence",
                sequenceName = "catering_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "catering_sequence"
        )
        private Long id;
        private String typeFood;
        private String theme;
        @ManyToMany(mappedBy = "caterings")
        private Set<Event> events = new HashSet<>();


        public Catering() {
                }
}
