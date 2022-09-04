package jazs23884nbp.s23884nbp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<String> HandlerRuntimeExecption(HttpClientErrorException exception) {

        switch (exception.getStatusCode()){
            case INTERNAL_SERVER_ERROR :
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception thorw: 404" );
            case  NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception thorw: 400" );
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception thorw: 502" );

    }
}


