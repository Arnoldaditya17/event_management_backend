package com.project.UniversityEventManagement.controller;

import com.project.UniversityEventManagement.model.Event;
import com.project.UniversityEventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("api/event")
    public String addEvent(@Valid @RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PostMapping("api/events")
    public String addEvents(@Valid @RequestBody List<Event> events) {
        return eventService.addEvents(events);
    }
    
    @PutMapping("api/{eventId}")
    public String updateEvent(@PathVariable Long eventId, @RequestBody @Valid Event updatedEvent) {
         return eventService.updateEvent(eventId, updatedEvent);
    }

    @DeleteMapping("api/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @GetMapping("api/byDate")
    public List<Event> getAllEventsByDate(@RequestParam("date") LocalDate date) {
        return eventService.getAllEventsByDate(date);
    }


    @GetMapping("api/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("api/{eventId}")
    public Object getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }


}