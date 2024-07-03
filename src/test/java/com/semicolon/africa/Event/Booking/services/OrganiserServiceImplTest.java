package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.dto.requests.CreateEventRequest;
import com.semicolon.africa.Event.Booking.dto.requests.CreateGuestRequest;
import com.semicolon.africa.Event.Booking.dto.requests.CreateOrganizerRequest;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;
import com.semicolon.africa.Event.Booking.dto.responses.CreateOrganizerResponse;
import com.semicolon.africa.Event.Booking.exceptions.EventBookingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
class OrganiserServiceImplTest {

    @Autowired
    public OrganizerService organizerService;

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
        CreateOrganizerResponse response = organizerService.register(registerRequest);
        assertTrue(response.getMessage().contains("success"));
    }

    @Test
    public void cantRegisterOrganizerWithSameEmail(){
        organizerService.register(registerRequest);
        assertThrows(EventBookingException.class, ()->organizerService.register(registerRequest));
    }

    @Test
    public void organizerCanCreateEvent(){
        CreateEventResponse createEventResponse = organizerService.createEvent(100L, eventRequest);
        assertTrue(createEventResponse.getMessage().contains("success"));
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
        organizerService.addGuestToEvent(200L, createGuestRequest);
    }
}