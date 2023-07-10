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
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerDao.findById(customer.getId());

        if(existingCustomer.isPresent()){
            Customer customerToUpdate = existingCustomer.get();

            if (!customer.getEmail().equals(customerToUpdate.getEmail())){
                customerToUpdate.setEmail(customer.getEmail());
            }
            if (!customer.getPassword().equals(customerToUpdate.getEmail())){
                customerToUpdate.setPassword(customer.getPassword());
            }
            if (!customer.getFullName().equals(customerToUpdate.getFullName())){
                customerToUpdate.setFullName(customer.getFullName());
            }
            if (!customer.getPhoneNumber().equals(customerToUpdate.getPhoneNumber())){
                customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
            }

            Customer updatedCustomer = customerDao.save(customerToUpdate);
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
