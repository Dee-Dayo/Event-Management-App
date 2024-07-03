package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.dto.requests.*;
import com.semicolon.africa.Event.Booking.dto.responses.AddTicketResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateGuestResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateOrganizerResponse;

import java.util.List;

public interface OrganizerService {
    CreateOrganizerResponse register(CreateOrganizerRequest request);
    CreateEventResponse createEvent(Long organizerId, CreateEventRequest createEventRequest);
    List<Event> getEventsFor(long organizerId);

    CreateGuestResponse addGuestToEvent(Long eventId, CreateGuestRequest createGuestRequest);

    AddTicketResponse addTicket(Long eventId, AddTicketRequest addTicketRequest);

    String addMultipleTicket(long eventId, AddMultipleTickets addMultipleTickets);
}
