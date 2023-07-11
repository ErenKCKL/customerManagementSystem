package ashina.customermanagementsystem.api.controller;

import ashina.customermanagementsystem.business.abstracts.CustomerService;
import ashina.customermanagementsystem.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/updateCustomerEmail/{id}")
    public ResponseEntity<Customer> updateCustomerEmail(@PathVariable("id") int id, @RequestParam("newEmail") String newEmail){
        Customer updatedCustomer = customerService.updateCustomerEmail(id, newEmail);
        return ResponseEntity.ok(updatedCustomer);
    }

    @PutMapping("updateCustomerPassword/{id}")
    public ResponseEntity<Customer> updateCustomerPassword(@PathVariable("id") int id, @RequestParam("newPassword") String newPassword){
        Customer updatedCustomer = customerService.updateCustomerPassword(id, newPassword);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        return customerService.findById(id).map(customer -> {
            customerService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }




}
