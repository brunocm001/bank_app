package ca.test.bankapp.exception;

public class UnknownErrorException extends RuntimeException {

    public UnknownErrorException(String message) {
        super(message);
    }

}
