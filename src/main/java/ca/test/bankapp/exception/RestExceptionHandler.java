package ca.test.bankapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static ca.test.bankapp.utility.BankUtils.clearExceptionMessage;
import static ca.test.bankapp.utility.BankUtils.trans;

@SuppressWarnings("NullableProblems")
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(trans("exception.http-message-not-readable"), status);
    }

    @ExceptionHandler({
            ValidationException.class,
    })
    public final ResponseEntity<Object> handleAllBadRequestException(Exception ex) {
        log.warn(ex.getMessage(), ex);

        if(ex.getMessage() != null) {
            String[] messages = ex.getMessage().split("Exception:");
            if(messages.length == 2) {
                return new ResponseEntity<>(clearExceptionMessage(messages[1].trim()), HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(clearExceptionMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            ResourceAccessException.class
    })
    public final ResponseEntity<Object> handleAllUnavailableServiceException(Exception ex) {
        log.warn(ex.getMessage(), ex);

        if(ex.getMessage() != null) {
            String[] messages = ex.getMessage().split("Exception:");
            if(messages.length == 2) {
                return new ResponseEntity<>(clearExceptionMessage(messages[1].trim()), HttpStatus.SERVICE_UNAVAILABLE);
            }
        }

        return new ResponseEntity<>(clearExceptionMessage(ex.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler({
            UnknownErrorException.class
    })
    public final ResponseEntity<Object> handleInternalSeverErrorException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(trans("exception.service-not-available"), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler({
            UnknownUserException.class,
    })
    public final ResponseEntity<Object> handleAllForbiddenException(Exception ex) {
        log.error(ex.getMessage(), ex);

        if(ex.getMessage() != null) {
            String[] messages = ex.getMessage().split("Exception:");
            if(messages.length == 2) {
                return new ResponseEntity<>(clearExceptionMessage(messages[1].trim()), HttpStatus.FORBIDDEN);
            }
        }

        return new ResponseEntity<>(clearExceptionMessage(ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({
            NotFoundException.class,
    })
    public final ResponseEntity<Object> handleAllNotFoundException(Exception ex) {
        log.warn(ex.getMessage(), ex);

        if(ex.getMessage() != null) {
            String[] messages = ex.getMessage().split("Exception:");
            if(messages.length == 2) {
                return new ResponseEntity<>(clearExceptionMessage(messages[1].trim()), HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>(clearExceptionMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            UsernameOrPasswordWrongException.class,
            UsernameNotFoundException.class
    })
    public final ResponseEntity<Object> handleAllUnauthorizedException(Exception ex) {
        log.error(ex.getMessage(), ex);

        if(ex.getMessage() != null) {
            String[] messages = ex.getMessage().split("Exception:");
            if(messages.length == 2) {
                return new ResponseEntity<>(messages[1].trim(), HttpStatus.UNAUTHORIZED);
            }
        }

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    // Gérer les violations d'intégrité des données
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        String message = "Erreur d'intégrité des données : " + ex.getMostSpecificCause().getMessage();
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        log.error("---------------------", ex);
        return new ResponseEntity<>(trans("exception.service-not-available"), statusCode);
    }

}