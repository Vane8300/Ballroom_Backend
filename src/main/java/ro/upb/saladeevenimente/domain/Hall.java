package ro.upb.saladeevenimente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String location;

    @Column
    private Long dimension;

    @JsonIgnore
    @OneToMany(mappedBy = "hall")
    private List<Reservation> reservationList;

    @OneToMany(mappedBy = "hall")
    List<SheetHall> sheetHalls;

    public Hall() {}

    public Hall(long id, long dimension, String location) {
        this.id = id;
        this.dimension = dimension;
        this.location = location;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public Long getDimension() { return dimension; }

    public void setDimension(Long dimension) { this.dimension = dimension; }

    public List<Reservation> getReservationList() { return reservationList; }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<SheetHall> getSheetHalls() { return sheetHalls; }

    public void setSheetHalls(List<SheetHall> sheetHalls) { this.sheetHalls = sheetHalls; }


}