package ro.upb.saladeevenimente.domain;

import javax.persistence.*;

@Entity
public class SheetHall {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    Hall hall;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    Worker worker;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Hall getHall() { return hall; }

    public void setHall(Hall hall) { this.hall = hall; }

    public Worker getWorker() { return worker; }

    public void setWorker(Worker worker) { this.worker = worker; }


}
