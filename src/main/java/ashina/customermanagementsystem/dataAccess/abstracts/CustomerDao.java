package ashina.customermanagementsystem.dataAccess.abstracts;

import ashina.customermanagementsystem.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    Optional<Customer> findById(int id);

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

}
