package com.ameed.demo.events;

public interface EventsServices {

    Iterable<Event> fetchAllEvents();

    Long createEvent(Event newEvent);

    Long removeEvent(Long eventId);
}
