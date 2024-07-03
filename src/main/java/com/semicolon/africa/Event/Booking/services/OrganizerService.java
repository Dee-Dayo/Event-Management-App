package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.dto.requests.CreateEventRequest;
import com.semicolon.africa.Event.Booking.dto.requests.CreateGuestRequest;
import com.semicolon.africa.Event.Booking.dto.requests.CreateOrganizerRequest;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateOrganizerResponse;

import java.util.List;

public interface OrganizerService {
    CreateOrganizerResponse register(CreateOrganizerRequest request);
    CreateEventResponse createEvent(Long organizerId, CreateEventRequest createEventRequest);
    List<Event> getEventsFor(long organizerId);

    void addGuestToEvent(Long eventId, CreateGuestRequest createGuestRequest);
}
