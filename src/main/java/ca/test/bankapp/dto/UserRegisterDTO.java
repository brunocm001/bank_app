package ca.test.bankapp.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String currency;
    private String password;
    private String confirmPassword;

}
