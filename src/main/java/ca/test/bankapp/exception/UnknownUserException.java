package ca.test.bankapp.exception;

public class UnknownUserException extends RuntimeException {

    public UnknownUserException(String message) {
        super(message);
    }

}
