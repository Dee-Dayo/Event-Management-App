package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Type;
import com.semicolon.africa.Event.Booking.data.repositories.OrganizerRepository;
import com.semicolon.africa.Event.Booking.data.repositories.TicketRepository;
import com.semicolon.africa.Event.Booking.dto.requests.*;
import com.semicolon.africa.Event.Booking.dto.responses.AddTicketResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateGuestResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateOrganizerResponse;
import com.semicolon.africa.Event.Booking.exceptions.EventBookingException;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.semicolon.africa.Event.Booking.data.models.Type.REGULAR;
import static com.semicolon.africa.Event.Booking.data.models.Type.VIP;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
class OrganiserServiceImplTest {

    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private TicketRepository ticketRepository;


    private CreateOrganizerRequest registerRequest;
    private CreateEventRequest eventRequest;

    @BeforeEach
    public void setUp(){
        registerRequest = new CreateOrganizerRequest();
        registerRequest.setBusinessName("Business Name");
        registerRequest.setPhoneNumber("09182918291");
        registerRequest.setEmail("email@email.com");
        registerRequest.setPassword("password");

        eventRequest = new CreateEventRequest();
        eventRequest.setEventName("TAPE 2024");
        eventRequest.setDescription("Gospel Concert");
        eventRequest.setLocation("Lekki Phase 1");
        eventRequest.setEventDateTime(LocalDateTime.of(2024, 7, 3, 18, 0));
    }

    @Test
    public void registerOrganiser(){
        assertThat(organizerRepository.count()).isEqualTo(4);
        CreateOrganizerResponse response = organizerService.register(registerRequest);
        assertTrue(response.getMessage().contains("success"));
        assertThat(organizerRepository.count()).isEqualTo(5);
    }

    @Test
    public void cantRegisterOrganizerWithSameEmail(){
        organizerService.register(registerRequest);
        assertThrows(EventBookingException.class, ()->organizerService.register(registerRequest));
    }

    @Test
    public void organizerCanCreateEvent(){
        assertThat(organizerService.getEventsFor(100L).size()).isEqualTo(3);
        CreateEventResponse createEventResponse = organizerService.createEvent(100L, eventRequest);
        assertTrue(createEventResponse.getMessage().contains("success"));
        assertThat(organizerService.getEventsFor(100L).size()).isEqualTo(4);
    }

    @Test
    public void organizerCreateEvent_CanCheckEvents(){
        assertThat(organizerService.getEventsFor(100L).size()).isEqualTo(3);

        organizerService.createEvent(100L, eventRequest);
        eventRequest.setEventName("ANOTHER EVENT");
        organizerService.createEvent(100L, eventRequest);
        assertThat(organizerService.getEventsFor(100L).size()).isEqualTo(5);
    }

    @Test
    public void organizerCanCreateGuestListForEvent(){
        CreateGuestRequest createGuestRequest = new CreateGuestRequest();
        createGuestRequest.setFirstName("Firstname");
        createGuestRequest.setLastName("Lastname");
        CreateGuestResponse response = organizerService.addGuestToEvent(200L, createGuestRequest);
        assertTrue(response.getMessage().contains("registered"));
    }

    @Test
    public void organizerCanAddTicketToEvent(){
        assertThat(ticketRepository.count()).isEqualTo(3);
        AddTicketRequest addTicketRequest = new AddTicketRequest();
        addTicketRequest.setPrice(BigDecimal.valueOf(15000));
        addTicketRequest.setType(VIP);
        AddTicketResponse response = organizerService.addTicket(200L, addTicketRequest);
        assertTrue(response.getMessage().contains("success"));
        assertThat(ticketRepository.count()).isEqualTo(4);
    }

    @Test
    public void organizerCanAddMultipleTicketsToEvent(){
        assertThat(ticketRepository.count()).isEqualTo(3);
        AddMultipleTickets addMultipleTickets = new AddMultipleTickets();
        addMultipleTickets.setType(REGULAR);
        addMultipleTickets.setPrice(BigDecimal.valueOf(5000));
        addMultipleTickets.setPieces(50L);
        String response = organizerService.addMultipleTicket(201L, addMultipleTickets);
        assertTrue(response.contains("success"));
        assertThat(ticketRepository.count()).isEqualTo(53);
    }


}