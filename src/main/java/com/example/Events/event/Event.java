package com.example.Events.event;


import com.example.Events.people.People;
import com.example.Events.catering.Catering;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"attendees", "caterings"})
@Table
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

public class Event{
    @Id
    @SequenceGenerator(
            name= "event_sequence",
            sequenceName= "event_sequence",
            allocationSize= 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    private Long id;
    private String eventName;
    private String contactInfo;
    private LocalDate eventDate;

    @OneToMany(mappedBy = "event")
    private Set<People> attendees = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "event_catering",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "catering_id")
    )
    private Set<Catering> caterings = new HashSet<>();

    public Event(String eventName, String contactInfo, LocalDate eventDate, Set<People> people) {
        this.eventName = eventName;
        this.contactInfo = contactInfo;
        this.eventDate = eventDate;
        this.attendees = people;
    }

    public Event(Long id, String eventName, String contactInfo, LocalDate eventDate, Set<People> people) {
        this.id = id;
        this.eventName = eventName;
        this.contactInfo = contactInfo;
        this.eventDate = eventDate;
        this.attendees = people;
    }

    public Event(String eventName, String contactInfo, LocalDate eventDate) {
        this.eventName = eventName;
        this.contactInfo = contactInfo;
        this.eventDate = eventDate;
    }


    public Event() {

    }

    public void setAttendees(People people){
        this.attendees.add(people);
    }
    public void setCatering(Catering catering){
        this.caterings.add(catering);
    }
}
