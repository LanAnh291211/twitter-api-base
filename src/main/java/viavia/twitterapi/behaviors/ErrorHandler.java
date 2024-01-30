package viavia.twitterapi.behaviors;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleCommonException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(500, e.getMessage());

        return ResponseEntity
                .status(errorResponse.getStatusCode())
                .body(errorResponse);
    }
}
