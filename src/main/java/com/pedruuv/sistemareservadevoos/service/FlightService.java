package com.pedruuv.sistemareservadevoos.service;

import com.pedruuv.sistemareservadevoos.dtos.CreateFlight;
import com.pedruuv.sistemareservadevoos.dtos.ReadFlight;
import com.pedruuv.sistemareservadevoos.mapper.FlightMapper;
import com.pedruuv.sistemareservadevoos.models.Flight;
import com.pedruuv.sistemareservadevoos.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public Flight createFlight(CreateFlight flightDto){
        Flight flight = FlightMapper.INSTANCE.createToEntity(flightDto);

        return repository.save(flight);
    }

    public List<ReadFlight> searchFlights(String origin, String destination, LocalDate departureTime){
        LocalDateTime startOfDay = departureTime.atStartOfDay();
        LocalDateTime endOfDay = departureTime.atTime(23, 59, 59);

        List<Flight> flights = repository.findByOriginAndDestinationAndDepartureTimeBetween(origin, destination, startOfDay, endOfDay);

        List<ReadFlight> flightsDto = FlightMapper.INSTANCE.entityToRead(flights);

        return flightsDto;
    }

    public List<ReadFlight> searchByOriginAndDestination(String origin, String destination){
        List<Flight> flights = repository.findByOriginAndDestination(origin, destination);
        List<ReadFlight> flightsDto = FlightMapper.INSTANCE.entityToRead(flights);

        return flightsDto;
    }
}
