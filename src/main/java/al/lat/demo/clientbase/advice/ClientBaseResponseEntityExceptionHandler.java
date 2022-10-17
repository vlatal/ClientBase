package al.lat.demo.clientbase.advice;

import al.lat.demo.clientbase.Failure;
import al.lat.demo.clientbase.exception.AddressNotFoundException;
import al.lat.demo.clientbase.exception.ClientNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientBaseResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            ConstraintViolationException.class,
            DataIntegrityViolationException.class,
    })
    protected ResponseEntity<Failure> handleIntegrityErrors() {
        Failure failure = new Failure("Could not process the request.");

        return new ResponseEntity<>(failure, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = {
            EmptyResultDataAccessException.class,
            ClientNotFoundException.class,
            AddressNotFoundException.class,
    })
    protected ResponseEntity<Failure> handleNonExisting() {
        Failure failure = new Failure("Entity does not exist.");

        return new ResponseEntity<>(failure, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {
            Exception.class,
            Throwable.class,
    })
    protected ResponseEntity<Failure> handleOther() {
        Failure failure = new Failure("Failure: For further details, contact responsible person.");

        return new ResponseEntity<>(failure, HttpStatus.NOT_FOUND);
    }
}
