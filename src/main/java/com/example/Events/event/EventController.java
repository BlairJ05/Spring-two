package com.example.Events.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path= "api/v1/event")
public class EventController {
    private final EventService eventService;


    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{eventId}")
    public com.example.Events.event.Event getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping
    public List<com.example.Events.event.Event> getEvents(){
        return eventService.getEvent();
    }

    @PostMapping
    public void registerNewEvent(@RequestBody Event event){
        eventService.addNewEvent(event);
    }

    @PutMapping("/{eventId}")
    public void updateEvent(
            @PathVariable Long eventId,
            @RequestParam(required = false) String eventName,
            @RequestParam(required = false) String contactInfo,
            @RequestParam(required = false) LocalDate eventDate) {
        eventService.updateEvent(eventId, eventName, contactInfo, eventDate);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
