package ro.upb.saladeevenimente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.upb.saladeevenimente.domain.Worker;
import ro.upb.saladeevenimente.service.WorkerService;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping("")
    public Worker addWorker(@RequestBody Worker worker) throws SQLException {
        return workerService.addWorker(worker);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("all")
    public List<Worker> getAllWorkers() throws SQLException {
        return workerService.getAllWorkers();
    }


    @CrossOrigin("http://localhost:3000")
    @GetMapping("all/{userId}")
    public List<Worker> getAllWorkersByUserId(@PathVariable Long userId) throws SQLException {
        return workerService.getAllWorkersByUserId(userId);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("hallsPerWorker")
    public HashMap<String, Integer> getNumberOfHallsForWorker() throws SQLException {
        return workerService.getNumberOfHallsForWorker();
    }


}
