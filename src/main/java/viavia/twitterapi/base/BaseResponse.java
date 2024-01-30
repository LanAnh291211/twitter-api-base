package viavia.twitterapi.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class BaseResponse {
    private boolean success;
    private int statusCode;
    private final String message;
}