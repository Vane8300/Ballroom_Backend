package ro.upb.saladeevenimente.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "confirmed")
    private boolean confirmed;

    @Column(name = "time")
    private String time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "reservation_date")
    private Date reservationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<Guest> guests;

    public Reservation(long id, boolean confirmed, String description, Date reservationDate, String time) {
        this.id = id;
        this.confirmed = confirmed;
        this.description = description;
        this.reservationDate = reservationDate;
        this.time = time;
    }

    public Reservation() {}

    public Reservation(long id, String description, Date reservation_date, String time) {
        this.id = id;
        this.description = description;
        this.reservationDate = reservation_date;
        this.time = time;

    }

    public Reservation(long id, boolean confirmed, String description,
                       Date reservation_date, String time, Hall h) {
        this.id = id;
        this.confirmed = confirmed;
        this.description = description;
        this.reservationDate = reservation_date;
        this.time = time;
        this.hall = h;
    }

    public Date getReservationDate() { return reservationDate; }

    public void setReservationDate(Date reservationDate) { this.reservationDate = reservationDate; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public boolean isConfirmed() { return confirmed; }

    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Hall getHall() { return hall; }

    public void setHall(Hall hall) { this.hall = hall; }

}
