package com.example.Events.catering;

import com.example.Events.event.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
        @JsonIgnore
        @ManyToMany(mappedBy = "caterings")
        public Set<Event> events = new HashSet<>();


        public Catering(String typeFood, String theme) {
                this.typeFood = typeFood;
                this.theme = theme;
        }

        public Catering() {

        }
        public void setEvent(Event event){
                this.events.add(event);
        }
}
