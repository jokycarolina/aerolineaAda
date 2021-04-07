package com.aerolinea.aerolinea.repository;

import com.aerolinea.aerolinea.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight,Integer> {
}
