package viavia.twitterapi.base;

import viavia.twitterapi.constants.StatusCode;

import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private String message;
    private StatusCode statusCode;

    public BaseException(String message) {
        this.message = message;
//        this.statusCode = StatusCode.BAD_REQUEST;
        this.statusCode = StatusCode.OK;
    }

    public BaseException(String message, StatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}