package ashina.customermanagementsystem.business.concretes;

import ashina.customermanagementsystem.business.abstracts.CustomerService;
import ashina.customermanagementsystem.dataAccess.abstracts.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

}
