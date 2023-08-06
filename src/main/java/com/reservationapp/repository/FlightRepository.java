package com.reservationapp.repository;

import com.reservationapp.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByLeavingFromAndGoingToAndDepartureDate(String leavingFrom, String goingTo, LocalDate departureDate);

}
