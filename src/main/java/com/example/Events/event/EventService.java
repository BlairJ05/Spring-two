package com.example.Events.event;

import com.example.Events.people.People;
import com.example.Events.catering.Catering;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventService {
    private final com.example.Events.event.EventRepository eventRepository;
    private final com.example.Events.people.PeopleRepository peopleRepository;

    private final com.example.Events.catering.CateringRepository cateringRepository;

    @Autowired
    public EventService(com.example.Events.event.EventRepository eventRepository, com.example.Events.people.PeopleRepository peopleRepository, com.example.Events.catering.CateringRepository cateringRepository) {
        this.eventRepository = eventRepository;
        this.peopleRepository = peopleRepository;
        this.cateringRepository = cateringRepository;
    }

    public List<Event> getEvent() {
        return eventRepository.findAll();
    }

    public void addNewEvent(com.example.Events.event.Event event) {
        Optional<com.example.Events.event.Event> eventObtional = eventRepository
                .findEventByContactInfo(event.getContactInfo());
        if (eventObtional.isPresent()) {
            throw new IllegalStateException("email taken");

        }
        eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        boolean exists = eventRepository.existsById(eventId);
        if (!exists) {
            throw new IllegalStateException("event with id " + eventId + " does not exists");
        }
        eventRepository.deleteById(eventId);
    }

    @Transactional
    public void updateEvent(Long eventId, String eventName, String contactInfo, LocalDate eventDate) {
        com.example.Events.event.Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException("event with id " + eventId + "Does not exist"));
        if (eventName != null &&
                eventName.length() > 0 &&
                !Objects.equals(event.getEventName(), eventName)) {
            event.setEventName(eventName);
        }
        if (contactInfo != null && !contactInfo.isEmpty() && !Objects.equals(event.getContactInfo(), contactInfo)) {
            Optional<com.example.Events.event.Event> eventOptional = eventRepository.findEventByContactInfo(contactInfo);
            if (eventOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            event.setContactInfo(contactInfo); // Corrected the field assignment
        }
        if (eventDate != null && !Objects.equals(event.getEventDate(), eventDate)) {
            event.setEventDate(eventDate);
        }
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException("Event with id " + eventId + " does not exist"));
    }

    public void addPeople(Long eventId, Long peopleId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException("event with id " + eventId + "Does not exist"));
        People people = peopleRepository.findById(peopleId)
                .orElseThrow(() -> new IllegalStateException("people with id " + peopleId + "Does not exist"));
        event.setAttendees(people);
        eventRepository.save(event);
    }
    public void addCatering(Long eventId, Long cateringId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException("event with id " + eventId + "Does not exist"));
        Catering catering = cateringRepository.findById(cateringId)
                .orElseThrow(() -> new IllegalStateException("people with id " + cateringId + "Does not exist"));
        event.setCatering(catering);
        eventRepository.save(event);
    }
}

