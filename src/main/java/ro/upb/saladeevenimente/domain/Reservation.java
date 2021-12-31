package ro.upb.saladeevenimente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "advance")
    private int advance;

    @Column(name = "confirmed")
    private boolean confirmed;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @JsonIgnore
    @OneToOne(mappedBy = "reservation")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getAdvance() { return advance; }

    public void setAdvance(int advance) { this.advance = advance; }

    public boolean isConfirmed() { return confirmed; }

    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Event getEvent() { return event; }

    public void setEvent(Event event) { this.event = event; }

    public Hall getHall() { return hall; }

    public void setHall(Hall hall) { this.hall = hall; }



}
