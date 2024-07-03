package com.semicolon.africa.Event.Booking.data.repositories;

import com.semicolon.africa.Event.Booking.data.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
