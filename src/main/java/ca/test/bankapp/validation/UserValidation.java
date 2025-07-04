package ca.test.bankapp.validation;

import ca.test.bankapp.dto.UserLoginDTO;
import ca.test.bankapp.dto.UserRegisterDTO;

public interface UserValidation {

    void validRegister(UserRegisterDTO userRegisterDTO);
    void validLogin(UserLoginDTO userLoginDTO);

}
