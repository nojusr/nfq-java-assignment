package ml.kelp.nfq.assignment.main.repository;

import ml.kelp.nfq.assignment.main.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
