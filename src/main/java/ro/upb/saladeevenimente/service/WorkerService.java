package ro.upb.saladeevenimente.service;

import org.springframework.stereotype.Service;
import ro.upb.saladeevenimente.domain.Worker;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public interface WorkerService {
    Worker addWorker(Worker worker) throws SQLException;
    List<Worker> getAllWorkers() throws SQLException;
    HashMap<String, Integer> getNumberOfHallsForWorker() throws SQLException;
    List<Worker> getAllWorkersByUserId(Long userId) throws SQLException;

}
