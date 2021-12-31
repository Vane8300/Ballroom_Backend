package ro.upb.saladeevenimente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.upb.saladeevenimente.domain.Hall;
import ro.upb.saladeevenimente.domain.Reservation;
import ro.upb.saladeevenimente.domain.User;
import ro.upb.saladeevenimente.dto.LoginDto;
import ro.upb.saladeevenimente.service.ReservationService;

import java.sql.SQLException;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping("")
    public Reservation addReservation(@RequestBody Reservation reservation) throws SQLException {
        return reservationService.addReservation(reservation);
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("/delete/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId) throws SQLException {
        reservationService.deleteReservation(reservationId);
    }



}
