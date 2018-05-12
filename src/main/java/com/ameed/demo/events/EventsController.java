package com.ameed.demo.events;

import com.ameed.demo.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/event")
public class EventsController {

    @Autowired
    private EventsServices services;

    @GetMapping("/all")
    public GeneralResponse getAll() {
        return new GeneralResponse(services.fetchAllEvents());
    }

    @PostMapping("")
    public GeneralResponse addEvent(@RequestBody Event newEvent) {
        return new GeneralResponse(services.createEvent(newEvent));
    }

    @DeleteMapping("/{eventId}")
    public GeneralResponse deleteEvent(@PathVariable("eventId") Long eventId) {
        throw new UnsupportedOperationException("Can't delete event " + eventId);

        // return new GeneralResponse<>(services.removeEvent(eventId));
    }

    //    @ExceptionHandler(UnsupportedOperationException.class)
    //    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    //    public GeneralResponse handleException(UnsupportedOperationException e) {
    //        e.printStackTrace();
    //        return new GeneralResponse(e);
    //    }
}
