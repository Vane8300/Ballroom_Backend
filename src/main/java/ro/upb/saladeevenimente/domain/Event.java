package ro.upb.saladeevenimente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_people")
    private int number_people;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getNumber_people() { return number_people; }

    public void setNumber_people(int number_people) { this.number_people = number_people; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Reservation getReservation() { return reservation; }

    public void setReservation(Reservation reservation) { this.reservation = reservation; }
}
