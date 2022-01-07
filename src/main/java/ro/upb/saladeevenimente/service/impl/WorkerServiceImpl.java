package ro.upb.saladeevenimente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.saladeevenimente.domain.Worker;
import ro.upb.saladeevenimente.repository.WorkerJdbcRepository;
import ro.upb.saladeevenimente.repository.WorkerJdbcRepositoryImpl;
import ro.upb.saladeevenimente.service.WorkerService;

import java.sql.SQLException;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private WorkerJdbcRepository workerJdbcRepository = new WorkerJdbcRepositoryImpl();

    @Override
    public Worker addWorker(Worker worker) throws SQLException {
        return workerJdbcRepository.addWorker(worker);
    }

    @Override
    public List<Worker> getAllWorkers() throws SQLException {
        return workerJdbcRepository.findAllWorkers();
    }

    @Override
    public List<Worker> getAllWorkersByUserId(Long userID) throws SQLException {
        return workerJdbcRepository.findAllWorkersByUserId(userID);
    }
}
