package ashina.customermanagementsystem.business.concretes;

import ashina.customermanagementsystem.business.abstracts.CustomerService;
import ashina.customermanagementsystem.dataAccess.abstracts.CustomerDao;
import ashina.customermanagementsystem.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerManager implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public Customer registerNewCustomer(Customer customer) {
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
    public boolean existsByEmail(String email) {
        return customerDao.existsByEmail(email);
    }
}
