package ml.kelp.nfq.assignment.main.exceptions;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(int id) {
        super("Could not find reservation " + id);
    }
}