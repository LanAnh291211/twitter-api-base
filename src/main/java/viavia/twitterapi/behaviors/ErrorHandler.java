package viavia.twitterapi.behaviors;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationCredentialsNotFoundException(
            AuthenticationCredentialsNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(401, "unauthorized");

        return ResponseEntity
                .status(errorResponse.getStatusCode())
                .body(errorResponse);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        ErrorResponse errorResponse = new ErrorResponse(403, "forbidden");

        return ResponseEntity
                .status(errorResponse.getStatusCode())
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleCommonException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(500, e.getMessage());

        return ResponseEntity
                .status(errorResponse.getStatusCode())
                .body(errorResponse);
    }
}
