package ml.kelp.nfq.assignment.main.repository;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findByCustomerSecret(String customerSecret);

    Reservation findOneById(Long id);

    List<Reservation> findBySpecialistOrderByTimeAddedDesc(Specialist specialist);
}
