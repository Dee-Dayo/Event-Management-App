package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.dto.requests.CreateGuestRequest;
import com.semicolon.africa.Event.Booking.dto.responses.CreateGuestResponse;

public interface GuestService {
    CreateGuestResponse register(Event event, CreateGuestRequest createGuestRequest);
}
