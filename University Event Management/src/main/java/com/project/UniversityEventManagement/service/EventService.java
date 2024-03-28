package com.project.UniversityEventManagement.service;

import com.project.UniversityEventManagement.model.Event;
import com.project.UniversityEventManagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;


    public String addEvent(Event event) {
        eventRepository.save(event);
        return "Event added successfully with ID: " + event.getEventId();
    }

    public String addEvents(List<Event> events) {
        eventRepository.saveAll(events);
        return events.size()+" Events added successfully";
    }

    public String updateEvent(Long eventId, Event updatedEvent) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isPresent()) {
            eventRepository.save(updatedEvent);
            return "Event with ID: " + eventId + " updated successfully";
        }

        return "Event with ID: " + eventId + " not found";
    }

    public String deleteEvent(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isPresent()) {
            eventRepository.deleteById(eventId);
            return "Event with ID: " + eventId + " deleted successfully";
        }

        return "Event with ID: " + eventId + " not found";
    }

    public List<Event> getAllEventsByDate(LocalDate date) {
        return eventRepository.findByDateBefore(date);
    }


    //=====================Extra==========================
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Object getEventById(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isPresent()) {
            return eventRepository.findById(eventId);
        }

        return "Event with ID: " + eventId + " not found";

    }
}
