package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.data.models.Organizer;
import com.semicolon.africa.Event.Booking.data.repositories.EventRepository;
import com.semicolon.africa.Event.Booking.dto.requests.CreateEventRequest;
import com.semicolon.africa.Event.Booking.dto.responses.CreateEventResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{
    private final ModelMapper modelMapper;
    private final EventRepository eventRepository;


    @Override
    public CreateEventResponse createEvent(Organizer organizer, CreateEventRequest createEventRequest) {
        Event event = modelMapper.map(createEventRequest, Event.class);
        event.setOrganizer(organizer);
        event = eventRepository.save(event);
        CreateEventResponse response = modelMapper.map(event, CreateEventResponse.class);
        response.setMessage("Event created successfully");
        return response;
    }
}
