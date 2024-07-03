package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.data.models.Ticket;
import com.semicolon.africa.Event.Booking.data.repositories.TicketRepository;
import com.semicolon.africa.Event.Booking.dto.requests.AddMultipleTickets;
import com.semicolon.africa.Event.Booking.dto.requests.AddTicketRequest;
import com.semicolon.africa.Event.Booking.dto.responses.AddTicketResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final ModelMapper modelMapper;
    private TicketRepository ticketRepository;

    @Override
    public AddTicketResponse createTicket(Event event, AddTicketRequest addTicketRequest) {
        Ticket ticket = modelMapper.map(addTicketRequest, Ticket.class);
        ticket.setEvent(event);
        ticket = ticketRepository.save(ticket);
        AddTicketResponse addTicketResponse = modelMapper.map(ticket, AddTicketResponse.class);
        addTicketResponse.setMessage("Ticket added successfully");
        return addTicketResponse;
    }

    @Override
    public String createMultipleTickets(Event event, AddMultipleTickets addMultipleTickets) {
         List<Ticket> tickets = new ArrayList<>();
            for (int i = 0; i < addMultipleTickets.getPieces(); i++) {
                Ticket ticket = modelMapper.map(addMultipleTickets, Ticket.class);
                ticket.setEvent(event);
                tickets.add(ticket);
            }
            ticketRepository.saveAll(tickets);
            return "Tickets added successfully";
    }
}
