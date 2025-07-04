package ca.test.bankapp.validation;

import ca.test.bankapp.dto.UserLoginDTO;
import ca.test.bankapp.dto.UserRegisterDTO;
import ca.test.bankapp.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class UserValidationImpl implements UserValidation {

    @Override
    public void validRegister(UserRegisterDTO userRegisterDTO) {
        if(userRegisterDTO == null) {
            throw new ValidationException("Les données doivent être envoyées");
        }
        else if(userRegisterDTO.getFirstName() == null) {
            throw new ValidationException("Le prénom doit être renseigné");
        }
        else if(userRegisterDTO.getLastName() == null) {
            throw new ValidationException("Le nom doit être renseigné");
        }
        else if(userRegisterDTO.getEmail() == null) {
            throw new ValidationException("L'adresse mail doit être renseigné");
        }
        else if(userRegisterDTO.getCurrency() == null) {
            throw new ValidationException("La devise doit être renseignée");
        }
        else if(userRegisterDTO.getPassword() == null) {
            throw new ValidationException("Le mot de passe doit être renseigné");
        }
        else if(userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            throw new ValidationException("Le mot de passe et la confirmation doivent être identique");
        }
    }

    @Override
    public void validLogin(UserLoginDTO userLoginDTO) {

    }

}
