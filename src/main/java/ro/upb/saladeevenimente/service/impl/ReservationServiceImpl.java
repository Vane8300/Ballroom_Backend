package ro.upb.saladeevenimente.service.impl;

import org.springframework.stereotype.Service;
import ro.upb.saladeevenimente.domain.Reservation;
import ro.upb.saladeevenimente.repository.ReservationJdbcRepository;
import ro.upb.saladeevenimente.repository.ReservationJdbcRepositoryImpl;
import ro.upb.saladeevenimente.service.ReservationService;

import java.sql.SQLException;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationJdbcRepository reservationJdbcRepository = new ReservationJdbcRepositoryImpl();

    @Override
    public Reservation addReservation(Reservation reservation) throws SQLException {
        return reservationJdbcRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) throws SQLException {
        reservationJdbcRepository.deleteById(id);
    }
}
