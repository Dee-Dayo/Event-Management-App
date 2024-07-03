package com.semicolon.africa.Event.Booking.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrganizerResponse {
    private Long id;
    private String email;
    private String message;
}
