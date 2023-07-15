package ashina.customermanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Import(WebConfig.class)
public class CustomerManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagementSystemApplication.class, args);
    }

}
