package ro.upb.saladeevenimente.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private  String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "worker")
    List<SheetHall> sheetHalls;

    @OneToMany(mappedBy = "worker")
    List<SheetUserWorker> sheetUserWorkers;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public List<SheetHall> getSheetHalls() { return sheetHalls; }

    public void setSheetHalls(List<SheetHall> sheetHalls) { this.sheetHalls = sheetHalls; }

    public List<SheetUserWorker> getSheetUserWorkers() {
        return sheetUserWorkers;
    }

    public void setSheetUserWorkers(List<SheetUserWorker> sheetUserWorkers) {
        this.sheetUserWorkers = sheetUserWorkers;
    }


}
