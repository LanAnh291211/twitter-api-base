package viavia.twitterapi.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class ErrorResponse extends BaseResponse {
    public ErrorResponse(boolean success, int statusCode, String message) {
        super(success, statusCode, message);
    }
}