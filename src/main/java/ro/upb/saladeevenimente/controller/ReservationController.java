package ro.upb.saladeevenimente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.upb.saladeevenimente.domain.Reservation;
import ro.upb.saladeevenimente.service.ReservationService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping("")
    public Reservation addReservation(@RequestBody  Reservation reservation) throws SQLException {
        return reservationService.addReservation(reservation);
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("/delete/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId) throws SQLException {
        reservationService.deleteReservation(reservationId);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("all/{userId}")
    public List<Reservation> getAllReservationsByUserId(@PathVariable Long userId) throws SQLException {
        return reservationService.getAllReservationsByUserId(userId);
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/confirm/{reservationId}")
    public void confirmReservation(@PathVariable Long reservationId, @RequestBody Reservation reservation) throws SQLException {
        reservationService.confirmReservation(reservationId, reservation);
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/edit/{reservationId}")
    public void editReservation(@PathVariable Long reservationId, @RequestBody Reservation reservation) throws SQLException {
        reservationService.editReservation(reservationId, reservation);
    }
}
