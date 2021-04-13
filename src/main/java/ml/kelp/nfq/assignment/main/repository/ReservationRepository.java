package ml.kelp.nfq.assignment.main.repository;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
