package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.dto.requests.AddMultipleTickets;
import com.semicolon.africa.Event.Booking.dto.requests.AddTicketRequest;
import com.semicolon.africa.Event.Booking.dto.responses.AddTicketResponse;

public interface TicketService {
    AddTicketResponse createTicket(Event event, AddTicketRequest addTicketRequest);

    String createMultipleTickets(Event event, AddMultipleTickets addMultipleTickets);
}
