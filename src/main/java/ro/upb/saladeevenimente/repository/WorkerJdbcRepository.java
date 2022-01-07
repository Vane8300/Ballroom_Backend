package ro.upb.saladeevenimente.repository;

import ro.upb.saladeevenimente.domain.Worker;

import java.sql.SQLException;
import java.util.List;

public interface WorkerJdbcRepository {
    Worker addWorker(Worker worker) throws SQLException;
    List<Worker> findAllWorkers() throws SQLException;
    List<Worker> findAllWorkersByUserId(Long userId) throws SQLException;
}
