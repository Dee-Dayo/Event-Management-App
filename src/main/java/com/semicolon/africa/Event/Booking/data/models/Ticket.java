package com.semicolon.africa.Event.Booking.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;

@Setter
@Getter
@Table(name = "tickets")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = STRING)
    private Type type;
    private BigDecimal price;


    @ManyToOne
    private Event event;
}
