package ro.upb.saladeevenimente.service;

import ro.upb.saladeevenimente.domain.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation) throws SQLException;
    void deleteReservation(Long reservationId) throws SQLException;
    List<Reservation> getAllReservationsByUserId(Long userId) throws SQLException;
    void confirmReservation(Long reservationId, Reservation reservation) throws SQLException;
    void editReservation(Long reservationId, Reservation reservation) throws SQLException;
}
