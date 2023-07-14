package ashina.customermanagementsystem.entities.concretes;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SessionHelper {
    public  String generateSessionToken(int id) {
        String sessionToken = UUID.randomUUID().toString();
        return sessionToken;
    }

}
