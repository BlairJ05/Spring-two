package com.example.Events.people;

import com.example.Events.event.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table
public class People {
    @Id
    @SequenceGenerator(name = "people_sequence", sequenceName = "people_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "people_sequence")
    private Long id;

    private String name;
    private String email;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="event_id", referencedColumnName = "id")
    private Event event;



    public People(String name, String email, Event event) {
        this.name = name;
        this.email = email;
        this.event = event;
    }

    public People() {

    }
}

