package com.pedruuv.sistemareservadevoos.controller;

import com.pedruuv.sistemareservadevoos.dtos.CreateFlight;
import com.pedruuv.sistemareservadevoos.dtos.ReadFlight;
import com.pedruuv.sistemareservadevoos.models.Flight;
import com.pedruuv.sistemareservadevoos.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping("/create")
    public ResponseEntity<Flight> createFlight(@RequestBody @Valid CreateFlight flightDto){
        Flight flight = service.createFlight(flightDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(flight);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ReadFlight>> searchFlights(@RequestParam String origin, @RequestParam String destination, @RequestParam String departureTime){
        LocalDate date = LocalDate.parse(departureTime);
        List<ReadFlight> filteredFlights = service.searchFlights(origin, destination, date);

        return ResponseEntity.status(HttpStatus.OK).body(filteredFlights);
    }

    @GetMapping("/search/origin&destination")
    public ResponseEntity<List<ReadFlight>> searchFlightsByOriginAndDestination(@RequestParam String origin, @RequestParam String destination){
        List<ReadFlight> filteredFlights = service.searchByOriginAndDestination(origin, destination);

        return ResponseEntity.status(HttpStatus.OK).body(filteredFlights);
    }

}
