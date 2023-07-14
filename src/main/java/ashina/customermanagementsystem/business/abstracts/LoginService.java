package ashina.customermanagementsystem.business.abstracts;

import ashina.customermanagementsystem.entities.concretes.LoginRequest;
import ashina.customermanagementsystem.entities.concretes.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest request);
}
