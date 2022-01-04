package ro.upb.saladeevenimente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import ro.upb.saladeevenimente.domain.Hall;
import ro.upb.saladeevenimente.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HallJdbcRepositoryImpl implements HallJdbcRepository {

    @Override
    public Hall save(Hall hall) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("INSERT INTO hall(name, location, dimension)" + "values (?, ?,?)");
        c.setString(1, hall.getName());
        c.setString(2, hall.getLocation());
        c.setLong(3, hall.getDimension());
        boolean resultSet = c.execute();
        return null;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("DELETE FROM hall where id=?");
        c.setLong(1, id);
        c.executeUpdate();
    }

    @Override
    public void update(Long id, Hall hall) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("UPDATE hall SET name=?, dimension=?, location=?  WHERE id=?");
        c.setString(1, hall.getName());
        c.setLong(2, hall.getDimension());
        c.setString(3, hall.getLocation());
        c.setLong(4, id);
        c.executeUpdate();
    }

    @Override
    public List<Hall> show() throws SQLException {
        List<Hall> hallList = new ArrayList<Hall>();
        Hall h = null;
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("select * from hall");
        ResultSet resultSet = c.executeQuery();
        while(resultSet.next()){

            h = new Hall(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getLong("dimension"),
                    resultSet.getString("location"));
            hallList.add(h);
        }
        return hallList;
    }


}
