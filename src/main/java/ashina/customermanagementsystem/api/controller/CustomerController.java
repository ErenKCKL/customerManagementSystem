package ashina.customermanagementsystem.api.controller;

import ashina.customermanagementsystem.business.abstracts.CustomerService;
import ashina.customermanagementsystem.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/registerNewCustomer")
    public ResponseEntity<Customer> registerNewCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.registerNewCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }


}
