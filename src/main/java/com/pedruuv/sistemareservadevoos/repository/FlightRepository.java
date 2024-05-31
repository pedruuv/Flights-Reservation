package com.pedruuv.sistemareservadevoos.repository;

import com.pedruuv.sistemareservadevoos.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
    List<Flight> findByOriginAndDestinationAndDepartureTimeBetween(String origin, String destination, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Flight> findByOriginAndDestination(String origin, String destination);
}
