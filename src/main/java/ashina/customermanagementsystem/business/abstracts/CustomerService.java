package ashina.customermanagementsystem.business.abstracts;

import ashina.customermanagementsystem.entities.concretes.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer registerNewCustomer(Customer customer);

    void deleteById(int id);

    Customer updateCustomerEmail(int id, String newEmail);

    Customer updateCustomerPassword(int id, String newPassword);

    List<Customer> getAllCustomer();
    Optional<Customer> findById(int id);

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);
}
