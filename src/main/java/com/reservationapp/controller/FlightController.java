package com.reservationapp.controller;

import com.reservationapp.entity.Flight;
import com.reservationapp.service.FlightService;
import com.reservationapp.exception.FlightNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam(name = "leavingFrom") String leavingFrom,
            @RequestParam(name = "goingTo") String goingTo,
            @RequestParam(name = "departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {
        try {
            return flightService.searchFlights(leavingFrom, goingTo, departureDate);
        } catch (FlightNotFoundException ex) {
            // Handle the FlightNotFoundException and return an appropriate response
            // For example, you can return a 404 Not Found response with an error message.
            // You can also create a custom error response DTO for consistency.
            // For simplicity, we'll rethrow the exception here.
            throw ex;
        }

//        try {
//            List<Flight> flights = flightService.searchFlights(leavingFrom, goingTo, departureDate);
//            return flights.toString();
//        } catch (FlightNotFoundException ex) {
//            return "No flights found for the provided search criteria.";
//        } catch (Exception ex) {
//            return "An internal server error occurred: " + ex.getMessage();
//        }
    }
}

