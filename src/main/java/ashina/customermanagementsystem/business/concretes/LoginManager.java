package ashina.customermanagementsystem.business.concretes;

import ashina.customermanagementsystem.business.abstracts.CustomerService;
import ashina.customermanagementsystem.business.abstracts.LoginService;
import ashina.customermanagementsystem.entities.concretes.Customer;
import ashina.customermanagementsystem.entities.concretes.LoginRequest;
import ashina.customermanagementsystem.entities.concretes.LoginResponse;
import ashina.customermanagementsystem.entities.concretes.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginManager implements LoginService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SessionHelper sessionHelper;

    @Override
    public LoginResponse login(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        Optional<Customer> customerOptional = customerService.findByEmail(email);
        if (customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            if (customer.getPassword().equals(password)){
                String sessionToken = sessionHelper.generateSessionToken(customer.getId());
                LoginResponse response = new LoginResponse();
                response.setSessionToken(sessionToken);
                return response;
            }
        }
        throw new RuntimeException("Invaild Email or Password");
    }
}
