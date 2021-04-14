package ml.kelp.nfq.assignment.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isVisiting;

    private Long timeStarted;
    private Long timeEnded;

    private Long timeAdded;

    private int shortId; // 4-digit number used for quick reference

    private String customerSecret; // string that is used for referencing the reservation via URL

    @OneToOne(targetEntity = Customer.class)
    @JoinColumn(name="customerFk")
    private Customer customer;

    @ManyToOne(targetEntity = Specialist.class)
    @JoinColumn(name="specialistFk")
    private Specialist specialist;

    public  Reservation(){}

    public Reservation(Long id, boolean isVisiting, Customer customer, Specialist specialist, Long timeStarted, Long timeEnded, Long timeAdded, int shortId, String customerSecret) {
        this.id = id;
        this.isVisiting = isVisiting;
        this.customer = customer;
        this.specialist = specialist;
        this.timeAdded = timeAdded;
        this.timeStarted = timeStarted;
        this.timeEnded = timeEnded;
        this.shortId = shortId;
        this.customerSecret = customerSecret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Long timeStarted) {
        this.timeStarted = timeStarted;
    }

    public Long getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(Long timeEnded) {
        this.timeEnded = timeEnded;
    }

    public int getShortId() {
        return shortId;
    }

    public void setShortId(int shortId) {
        this.shortId = shortId;
    }

    public String getCustomerSecret() {
        return customerSecret;
    }

    public void setCustomerSecret(String customerSecret) {
        this.customerSecret = customerSecret;
    }

    public Long getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Long timeAdded) {
        this.timeAdded = timeAdded;
    }
}
