package ro.upb.saladeevenimente.repository;


import ro.upb.saladeevenimente.domain.User;

import java.sql.SQLException;

public interface UserJdbcRepository {
    User save(User user) throws SQLException;
    User findUserByEmailAndPassword(String email, String password) throws SQLException;
}
