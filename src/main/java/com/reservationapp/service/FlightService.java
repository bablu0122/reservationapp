package com.reservationapp.service;


import com.reservationapp.entity.Flight;
import com.reservationapp.exception.FlightNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);

    List<Flight> searchFlights(String leavingFrom, String goingTo, LocalDate departureDate) throws FlightNotFoundException;
}



