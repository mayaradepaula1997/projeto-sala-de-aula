package br.com.turmajava.turmajava.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<StandardError> handlerApiException(ApiException e) {
        StandardError err = new StandardError(e.getStatus().value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(e.getStatus()).body(err);
    }

    // Outras exceções podem ser tratadas aqui
}
