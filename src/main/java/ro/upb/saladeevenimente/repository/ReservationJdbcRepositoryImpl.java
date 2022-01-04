package ro.upb.saladeevenimente.repository;

import org.apache.catalina.User;
import ro.upb.saladeevenimente.domain.Hall;
import ro.upb.saladeevenimente.domain.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationJdbcRepositoryImpl implements ReservationJdbcRepository{

    @Override
    public Reservation addReservation(Reservation reservation) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("INSERT INTO reservation(confirmed, " +
                "description, reservation_date, time, hall_id, user_id)" + "values (?,?,?,?,?,?)");
        c.setBoolean(1, reservation.isConfirmed());
        c.setString(2, reservation.getDescription());
//        c.setInt(3, reservation.getNumber_of_people());
        c.setDate(3, reservation.getReservationDate());
        c.setString(4, reservation.getTime());
//        c.setString(6, reservation.getLocation());
        c.setLong(5, reservation.getHall().getId());
        c.setLong(6,reservation.getUser().getId());
        boolean resultSet = c.execute();
        return null;
    }

    @Override
    public void deleteReservation(Long reservationId) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("DELETE FROM reservation where id=?");
        c.setLong(1, reservationId);
        c.executeUpdate();
    }

    @Override
    public List<Reservation> findAllReservationsByUserId(Long userId) throws SQLException {
        List<Reservation> reservations = new ArrayList<Reservation>();
        Reservation reservation1 = null;
        Hall h = null;
        User u = null;
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("select * from reservation");

        ResultSet resultSet = c.executeQuery();
        while(resultSet.next()){
            Long hallId = resultSet.getLong("hall_id");
            Long userID = resultSet.getLong("user_id");
            PreparedStatement c1 = connection.prepareStatement("select * from hall where id=?");
            c1.setLong(1, hallId);
            ResultSet resultSet1 = c1.executeQuery();

            if (resultSet1.next()) {
                h = new Hall(resultSet1.getLong("id"),
                        resultSet1.getLong("dimension"),
                        resultSet1.getString("location"),
                        resultSet1.getString("name"));
            }

            reservation1 = new Reservation(
                    resultSet.getLong("id"),
                    resultSet.getBoolean("confirmed"),
                    resultSet.getString("description"),
                    resultSet.getDate("reservation_date"),
                    resultSet.getString("time"),
                    h);
            reservations.add(reservation1);
        }
        return reservations;
    }

    @Override
    public void confirmReservation(Long reservationId, Reservation reservation) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("UPDATE reservation SET confirmed=true WHERE id=?");
        c.setLong(1, reservationId);
        c.executeUpdate();
    }

    @Override
    public void editReservation(Long reservationId, Reservation reservation) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement d = connection.prepareStatement("SELECT * FROM reservation");
        ResultSet resultSet = d.executeQuery();
        if (resultSet.next()) {
            String prev_description = resultSet.getString("description");
//            String prev_location = resultSet.getString("location");
//            int prev_number_of_people = resultSet.getInt("number_of_people");
            Date prev_reservation_date = resultSet.getDate("reservation_date");
            String prev_time = resultSet.getString("time");

            PreparedStatement c = connection.prepareStatement("UPDATE reservation SET description=?, reservation_date=?," +
                    " time=? WHERE id=?");
            if (reservation.getDescription().equals("")) {
               reservation.setDescription(prev_description);
            }
//            if (reservation.getLocation().equals("")) {
//                reservation.setLocation(prev_location);
//            }
//            if (reservation.getNumber_of_people() == 0) {
//                reservation.setNumber_of_people(prev_number_of_people);
//            }
            if (reservation.getReservationDate() == null) {
                reservation.setReservationDate(prev_reservation_date);
            }
            if (reservation.getTime().equals("")) {
                reservation.setTime(prev_time);
            }
            c.setString(1, reservation.getDescription());
//            c.setString(2, reservation.getLocation());
//            c.setInt(3, reservation.getNumber_of_people());
            c.setDate(2, reservation.getReservationDate());
            c.setString(3, reservation.getTime());
            c.setLong(4, reservationId);
            c.executeUpdate();

        }

    }
}
