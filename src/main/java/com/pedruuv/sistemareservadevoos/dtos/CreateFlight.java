package com.pedruuv.sistemareservadevoos.dtos;

import java.time.LocalDateTime;

public record CreateFlight(String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
}
