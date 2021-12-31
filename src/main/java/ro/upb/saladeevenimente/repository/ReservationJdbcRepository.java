package ro.upb.saladeevenimente.repository;

import ro.upb.saladeevenimente.domain.Reservation;

import java.sql.SQLException;
import java.util.logging.LogManager;

public interface ReservationJdbcRepository {
    Reservation save(Reservation reservation) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
