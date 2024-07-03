package com.semicolon.africa.Event.Booking.data.repositories;

import com.semicolon.africa.Event.Booking.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
