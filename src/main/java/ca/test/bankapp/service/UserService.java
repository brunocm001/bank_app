package ca.test.bankapp.service;

import ca.test.bankapp.dto.UserDTO;
import ca.test.bankapp.dto.UserRegisterDTO;
import ca.test.bankapp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    User createUser(UserRegisterDTO userRegisterDTO);
    String authenticateUser(String email, String password);
    UserDTO getUser(UserDetails userDetails);

}
