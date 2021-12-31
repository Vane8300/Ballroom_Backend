package ro.upb.saladeevenimente.service;

import ro.upb.saladeevenimente.domain.Reservation;

import java.sql.SQLException;

public interface ReservationService {
    Reservation addReservation(Reservation reservation) throws SQLException;
    void deleteReservation(Long id) throws SQLException;
}
