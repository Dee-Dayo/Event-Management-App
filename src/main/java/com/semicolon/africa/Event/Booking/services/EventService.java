package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.data.models.Guest;
import com.semicolon.africa.Event.Booking.data.models.Organizer;
import com.semicolon.africa.Event.Booking.dto.requests.CreateEventRequest;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;

import java.util.Collection;
import java.util.List;

public interface EventService {
    CreateEventResponse createEvent(Organizer organizer, CreateEventRequest createEventRequest);

    Event findEventBy(Long eventId);

    List<Guest> getGuestsFor(long eventId);
}
