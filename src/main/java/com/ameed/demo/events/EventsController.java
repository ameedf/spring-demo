package com.ameed.demo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    @Autowired
    private EventsServices services;

    @GetMapping("/rest/api/event/all")
    public Iterable<Event> getAll() {
        return services.fetchAllEvents();
    }

    @PostMapping("/rest/api/event")
    public Long addEvent(@RequestBody Event newEvent) {
        return services.createEvent(newEvent);
    }

    @DeleteMapping("/rest/api/event/{eventId}")
    public Long addEvent(@PathVariable("eventId") Long eventId) {
        return services.removeEvent(eventId);
    }
}
