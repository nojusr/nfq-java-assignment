package ml.kelp.nfq.assignment.main.repository;

import ml.kelp.nfq.assignment.main.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends  JpaRepository<Specialist, Integer> {
}
