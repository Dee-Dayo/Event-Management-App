package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.dto.requests.PurchaseTicketRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
class EventServiceImplTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testCanViewAllGuestsForAnEvent(){
        assertThat(eventService.getGuestsFor(200L).size()).isEqualTo(6);
    }

    @Test
    public void testCanPurchaseTicketForEvent(){
        PurchaseTicketRequest purchaseTicketRequest = new PurchaseTicketRequest();
    }
}