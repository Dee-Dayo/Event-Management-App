package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Organizer;
import com.semicolon.africa.Event.Booking.dto.requests.CreateEventRequest;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;

public interface EventService {
    CreateEventResponse createEvent(Organizer organizer, CreateEventRequest createEventRequest);
}
