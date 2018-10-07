package com.ameed.demo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsServicesImpl implements EventsServices {

    @Autowired
    private EventsRepository dao;

    @Override
    public Iterable<Event> fetchAllEvents() {
        return dao.findAll();
    }

    @Override
    public Long createEvent(Event newEvent) {
        return dao.save(newEvent).getId();
    }

    @Override
    public Long removeEvent(Long eventId) {
        dao.deleteById(eventId);
        return eventId;
    }
}
