package ashina.customermanagementsystem.business.concretes;

import ashina.customermanagementsystem.business.abstracts.CustomerService;
import ashina.customermanagementsystem.dataAccess.abstracts.CustomerDao;
import ashina.customermanagementsystem.entities.concretes.Customer;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Resource
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer registerNewCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerDao.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerDao.deleteById(id);
    }

    @Override
    public Customer updateCustomerEmail(int id, String newEmail) {
        Optional<Customer> existingCustomer = customerDao.findById(id);

        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setEmail(newEmail);
            Customer updatedCustomer = customerDao.save(customer);
            return updatedCustomer;
        } else {
            throw new RuntimeException("Customer Not Found");
        }
    }

    @Override
    public Customer updateCustomerPassword(int id, String newPassword) {
        Optional<Customer> existingCustomer = customerDao.findById(id);

        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setPassword(newPassword);
            Customer updatedCustomer = customerDao.save(customer);
            return updatedCustomer;
        } else {
            throw new RuntimeException("Customer Not Found");
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerDao.findById(id);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerDao.findByEmail(email);
    }

    @Override
    public List<String> getAllEmails() {
        List<Customer> customers = customerDao.findAll();
        return customers.stream().map(Customer::getEmail).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerDao.existsByEmail(email);
    }
}
