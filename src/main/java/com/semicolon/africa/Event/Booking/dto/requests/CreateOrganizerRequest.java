package com.semicolon.africa.Event.Booking.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrganizerRequest {
    public String businessName;
    public String phoneNumber;
    public String email;
    public String password;
}
