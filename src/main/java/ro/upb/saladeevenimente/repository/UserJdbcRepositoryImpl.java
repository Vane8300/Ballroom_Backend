package ro.upb.saladeevenimente.repository;

import ro.upb.saladeevenimente.domain.User;

import java.sql.*;

public class UserJdbcRepositoryImpl implements  UserJdbcRepository{

    @Override
    public User save(User user) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("INSERT INTO user(first_name, last_name, email, password)" + "values (?,?,?,?)");
        c.setString(1, user.getFirstName());
        c.setString(2, user.getLastName());
        c.setString(3, user.getEmail());
        c.setString(4, user.getPassword());
        boolean resultSet = c.execute();
        return null;

    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement("select * from user where email=? and password=?");
        c.setString(1, email);
        c.setString(2, password);
        ResultSet resultSet = c.executeQuery();
        User user = new User();
        while(resultSet.next()){
            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
        }
        return user;
    }

}
