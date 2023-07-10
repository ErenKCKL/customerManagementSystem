package ashina.customermanagementsystem.dataAccess.abstracts;

import ashina.customermanagementsystem.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
