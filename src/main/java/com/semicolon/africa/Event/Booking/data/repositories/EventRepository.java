package com.semicolon.africa.Event.Booking.data.repositories;

import com.semicolon.africa.Event.Booking.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
