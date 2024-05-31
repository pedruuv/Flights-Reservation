package com.pedruuv.sistemareservadevoos.mapper;

import com.pedruuv.sistemareservadevoos.dtos.CreateFlight;
import com.pedruuv.sistemareservadevoos.dtos.ReadFlight;
import com.pedruuv.sistemareservadevoos.models.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    Flight createToEntity(CreateFlight createFlight);

    List<ReadFlight> entityToRead(List<Flight> flights);
}
