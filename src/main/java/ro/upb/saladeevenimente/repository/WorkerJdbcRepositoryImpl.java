package ro.upb.saladeevenimente.repository;

import ro.upb.saladeevenimente.domain.Hall;
import ro.upb.saladeevenimente.domain.Reservation;
import ro.upb.saladeevenimente.domain.Worker;

import java.sql.*;
import java.util.*;

public class WorkerJdbcRepositoryImpl implements  WorkerJdbcRepository{

    @Override
    public Worker addWorker(Worker worker) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement(
                "INSERT INTO worker(first_name,last_name,email,phone,available,start_vacation,end_vacation)"
                        + "values (?,?,?,?,?,?,?)");
        c.setString(1, worker.getFirstname());
        c.setString(2, worker.getLastname());
        c.setString(3, worker.getEmail());
        c.setString(4, worker.getPhone());
        c.setBoolean(5, worker.getAvailable());
        c.setDate(6, worker.getStart_vacation());
        c.setDate(7, worker.getEnd_vacation());
        boolean resultSet = c.execute();
        return null;
    }

    @Override
    public List<Worker> findAllWorkers() throws SQLException {
        List<Worker> workers = new ArrayList<Worker>();
        Worker w = null;
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement(
                "SELECT * FROM worker");
        ResultSet resultSet = c.executeQuery();

        while (resultSet.next()) {

            w = new Worker(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone"),
                    resultSet.getBoolean("available"),
                    resultSet.getDate("start_vacation"),
                    resultSet.getDate("end_vacation"));
            workers.add(w);
        }
        return workers;
    }

    @Override
    public List<Worker> findAllWorkersByUserId(Long userId) throws SQLException {
        List<Worker> workers = new ArrayList<Worker>();
        Worker w1 = null;
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement(
                "SELECT w.* FROM worker w JOIN sheet_user_worker suw on w.id = suw.worker_id " +
                        "JOIN user u on suw.user_id = u.id WHERE u.id=?");
        c.setLong(1, userId);
        ResultSet resultSet = c.executeQuery();
        while (resultSet.next()) {
            w1 = new Worker(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone"),
                    resultSet.getBoolean("available"),
                    resultSet.getDate("start_vacation"),
                    resultSet.getDate("end_vacation")
            );
            workers.add(w1);
        }
        return workers;
    }

    // ========================================= Subquery #5 ===========================
    @Override
    public HashMap<String, Integer> findNumberOfHallsForWorker() throws SQLException {
        HashMap<String, Integer> hallsPerWorker = new HashMap<String, Integer>();
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proiectbd",
                "root",
                "root");
        PreparedStatement c = connection.prepareStatement(
                "select w.id, concat(w.first_name,' ',w.last_name) as Name, " +
                        "(select count(*) from sheet_hall sh where sh.worker_id = w.id) " +
                        "AS NoHalls " +
                        "from worker w");
        ResultSet resultSet = c.executeQuery();
        while (resultSet.next()) {
            hallsPerWorker.put(resultSet.getString("Name"), resultSet.getInt("NoHalls"));
        }
        return hallsPerWorker;
    }


}
