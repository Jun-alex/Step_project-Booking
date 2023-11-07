package models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Booking {
    private List<Human> humans;
    private String destination;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
    private int id;
    private int idFlight;
    public Booking(List<Human> humans, int id, String destination, int idFlight ) {
        this.humans = humans;
        this.destination = destination;
        this.dateCreate = LocalDate.now();
        this.dateUpdate = LocalDate.now();
        this.id = id;
        this.idFlight = idFlight;
    }
    public List<Human> getHumans() {return humans;}
    public void setHumans(List<Human> humans) {this.humans = humans;}
    public LocalDate getDateCreate() {return dateCreate;}
    public LocalDate getDateUpdate() {return dateUpdate;}
    public void setDateUpdate(LocalDate dateUpdate) {this.dateUpdate = dateUpdate;}
    public int getId() {return id;}
    public String getDestination() {return destination;}
    public void setDestination(String destination) {this.destination = destination;}
    public  int getIdFlight(){ return idFlight; }
    @Override
    public String toString() {
        StringBuilder humansList = new StringBuilder();
        for (Human human: humans) {
            humansList.append(human.toString()).append("\n");
        }
        final StringBuilder sb = new StringBuilder()
                .append("Booking= {")
                .append("humans count=").append(humans.size())
                .append("humans =").append(humansList)
                .append("destination =").append(destination)
                .append(", dateCreate='").append(dateCreate).append('\'')
                .append(", dateUpdate='").append(dateUpdate).append('\'')
                .append(", id='").append(id).append('\'')
                .append(", idFlight='").append(idFlight).append('\'')
                .append('}');
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && Objects.equals(humans, booking.humans) && Objects.equals(dateCreate, booking.dateCreate) && Objects.equals(dateUpdate, booking.dateUpdate) && Objects.equals(destination, booking.destination);
    }
    @Override
    public int hashCode() {
        return Objects.hash(humans, dateCreate, dateUpdate, id, destination);
    }
}
