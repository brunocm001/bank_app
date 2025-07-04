package ca.test.bankapp.exception;

public class UsernameOrPasswordWrongException extends RuntimeException {

    public UsernameOrPasswordWrongException(String message) {
        super(message);
    }

}