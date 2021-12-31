package ro.upb.saladeevenimente.repository;

import ro.upb.saladeevenimente.domain.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationJdbcRepositoryImpl implements ReservationJdbcRepository{

    @Override
    public Reservation save(Reservation reservation) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement(
                "INSERT INTO reservation(advance, confirmed, time, user_id, hall_id)" + "values (?,?,?,?,?)");
        c.setInt(1, reservation.getAdvance());
        c.setBoolean(2, reservation.isConfirmed());
        c.setString(3, reservation.getTime());
        c.setLong(4, reservation.getUser().getId());
        c.setLong(5, reservation.getHall().getId());
        boolean resultSet = c.execute();
        return null;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("DELETE FROM reservation where id=?");
        c.setLong(1, id);
        c.executeUpdate();
    }
}
