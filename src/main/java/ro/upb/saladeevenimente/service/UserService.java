package ro.upb.saladeevenimente.service;


import ro.upb.saladeevenimente.domain.User;

import java.sql.SQLException;

public interface UserService {
    User register(User user) throws SQLException;
    User getUserByEmailAndPassword(String email, String password) throws SQLException;

}
