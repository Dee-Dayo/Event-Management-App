package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.data.models.Organizer;
import com.semicolon.africa.Event.Booking.data.repositories.OrganizerRepository;
import com.semicolon.africa.Event.Booking.dto.requests.*;
import com.semicolon.africa.Event.Booking.dto.responses.AddTicketResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateGuestResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateOrganizerResponse;
import com.semicolon.africa.Event.Booking.exceptions.OrganizerAlreadyExistsException;
import com.semicolon.africa.Event.Booking.exceptions.OrganizerNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final OrganizerRepository organizerRepository;
    private final EventService eventService;
    private final GuestService guestService;
    private final TicketService ticketService;

    @Override
    public CreateOrganizerResponse register(CreateOrganizerRequest request) {
        if (organizerRepository.existsByEmail(request.getEmail())) throw new OrganizerAlreadyExistsException("An organizer with the email " + request.getEmail() + " already exists.");
        if (organizerRepository.existsByPhoneNumber(request.getPhoneNumber())) throw new OrganizerAlreadyExistsException("An organizer with the phone number " + request.getPhoneNumber() + " already exists.");

        Organizer organizer = modelMapper.map(request, Organizer.class);
        organizer.setPassword(passwordEncoder.encode(request.getPassword()));
        organizer = organizerRepository.save(organizer);
        CreateOrganizerResponse response = modelMapper.map(organizer, CreateOrganizerResponse.class);
        response.setMessage("Organizer created successfully");
        return response;
    }

    @Override
    public CreateEventResponse createEvent(Long organizerId, CreateEventRequest createEventRequest) {
        Organizer organizer = findById(organizerId);
        return eventService.createEvent(organizer, createEventRequest);
    }

    @Override
    public List<Event> getEventsFor(long organizerId) {
        return organizerRepository.findEventsBy(organizerId);
    }

    @Override
    public CreateGuestResponse addGuestToEvent(Long eventId, CreateGuestRequest createGuestRequest) {
        Event event = eventService.findEventBy(eventId);
        return guestService.register(event, createGuestRequest);
    }

    @Override
    public AddTicketResponse addTicket(Long eventId, AddTicketRequest addTicketRequest) {
        Event event = eventService.findEventBy(eventId);
        return ticketService.createTicket(event, addTicketRequest);
    }

    @Override
    public String addMultipleTicket(long eventId, AddMultipleTickets addMultipleTickets) {
        Event event = eventService.findEventBy(eventId);
        return ticketService.createMultipleTickets(event, addMultipleTickets);
    }

    private Organizer findById(Long organizerId) {
        return organizerRepository.findById(organizerId).orElseThrow(()->new OrganizerNotFoundException("Organizer not found"));
    }


}
