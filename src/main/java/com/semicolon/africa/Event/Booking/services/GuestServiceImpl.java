package com.semicolon.africa.Event.Booking.services;

import com.semicolon.africa.Event.Booking.data.models.Event;
import com.semicolon.africa.Event.Booking.data.models.Guest;
import com.semicolon.africa.Event.Booking.data.repositories.GuestRepository;
import com.semicolon.africa.Event.Booking.dto.requests.CreateGuestRequest;
import com.semicolon.africa.Event.Booking.dto.responses.CreateGuestResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService{
    private final GuestRepository guestRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreateGuestResponse register(Event event, CreateGuestRequest createGuestRequest) {
        Guest guest = modelMapper.map(createGuestRequest, Guest.class);
        guest.setEvent(event);
        guest = guestRepository.save(guest);
        CreateGuestResponse response = modelMapper.map(guest, CreateGuestResponse.class);
        response.setMessage("Successfully registered!");
        return response;
    }
}
