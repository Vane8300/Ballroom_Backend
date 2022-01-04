package ro.upb.saladeevenimente.repository;

import ro.upb.saladeevenimente.domain.Reservation;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.LogManager;

public interface ReservationJdbcRepository {
    Reservation addReservation(Reservation reservation) throws SQLException;
    void deleteReservation(Long reservationId) throws SQLException;
    List<Reservation> findAllReservationsByUserId(Long userId) throws SQLException;
    void confirmReservation(Long reservationId, Reservation reservation) throws SQLException;
    void editReservation(Long reservationId, Reservation reservation) throws SQLException;

}
