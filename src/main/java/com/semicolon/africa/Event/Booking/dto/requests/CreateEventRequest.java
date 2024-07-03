package com.semicolon.africa.Event.Booking.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateEventRequest {
    private String eventName;
    private String description;
    private String location;
    private LocalDateTime eventDateTime;
}
