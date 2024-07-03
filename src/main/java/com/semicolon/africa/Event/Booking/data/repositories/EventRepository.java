package com.semicolon.africa.Event.Booking.data.repositories;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.data.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT gu FROM Guest gu WHERE gu.event.id = :eventId")
    List<Guest> findGuestsBy(long eventId);
}
