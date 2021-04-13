package ml.kelp.nfq.assignment.main.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialists")
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password; // hashed

    @OneToMany(targetEntity = Reservation.class, mappedBy = "specialist")
    private List<Reservation> reservations;



    public Specialist() {}

    public Specialist(Long id, String email, String password, List<Reservation> reservations) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
