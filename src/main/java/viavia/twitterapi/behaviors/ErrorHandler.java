package viavia.twitterapi.behaviors;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import viavia.twitterapi.base.BaseException;
import viavia.twitterapi.base.ErrorResponse;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {

        ErrorResponse errorResponse = new ErrorResponse(
                false, e.getStatusCode().getValue(), e.getMessage());

        return ResponseEntity
                .status(e.getStatusCode().getValue())
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleCommonException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(false, 500, e.getMessage());

        return ResponseEntity
                .status(errorResponse.getStatusCode())
                .body(errorResponse);
    }
}
