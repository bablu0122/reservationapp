package com.reservationapp.service;


import com.reservationapp.entity.Flight;
import com.reservationapp.repository.FlightRepository;
import com.reservationapp.exception.FlightNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight addFlight(Flight flight) {
        // Perform any validation or business logic here before saving the flight
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> searchFlights(String leavingFrom, String goingTo, LocalDate departureDate) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByLeavingFromAndGoingToAndDepartureDate(leavingFrom, goingTo, departureDate);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("No flights found by search date.");
        }
        return flights;
    }
}

