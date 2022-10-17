package al.lat.demo.clientbase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends Exception {

    public ClientNotFoundException(Long id) {
        super(String.format("Client '%d' could not be found.", id));
    }
}
