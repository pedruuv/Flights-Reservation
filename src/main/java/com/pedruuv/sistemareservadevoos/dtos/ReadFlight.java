package com.pedruuv.sistemareservadevoos.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReadFlight(UUID id, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
}
