package com.semicolon.africa.Event.Booking.dto.requests;

import com.semicolon.africa.Event.Booking.data.models.Type;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AddTicketRequest {
    private Type type;
    private BigDecimal price;

}
