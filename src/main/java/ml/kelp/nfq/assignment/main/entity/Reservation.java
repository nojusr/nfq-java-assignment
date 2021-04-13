package ml.kelp.nfq.assignment.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long timeAdded;
    private boolean isVisiting;

    @OneToOne(targetEntity = Customer.class)
    @JoinColumn(name="customerFk")
    private Customer customer;

    @ManyToOne(targetEntity = Specialist.class)
    @JoinColumn(name="specialistFk")
    private Specialist specialist;

    public Reservation(Long id, Long timeAdded, boolean isVisiting, Customer customer, Specialist specialist) {
        this.id = id;
        this.timeAdded = timeAdded;
        this.isVisiting = isVisiting;
        this.customer = customer;
        this.specialist = specialist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeAdded() {
        return timeAdded;
    }

    public boolean getIsVisiting() {
        return isVisiting;
    }

    public void setIsVisiting(boolean visiting) {
        isVisiting = visiting;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }
}
