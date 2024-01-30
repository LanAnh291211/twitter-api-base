package viavia.twitterapi.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import viavia.twitterapi.constants.StatusCode;

@Getter
@EqualsAndHashCode(callSuper = true)
public class SuccessResponse<T> extends BaseResponse {
    private final T data;

    public SuccessResponse(T data) {
        super(true, StatusCode.OK.getValue(), "");
        this.data = data;
    }

    public SuccessResponse(T data, String message) {
        super(true, StatusCode.OK.getValue(), message);
        this.data = data;
    }

    public SuccessResponse(T data, StatusCode statusCode, String message) {
        super(true, statusCode.getValue(), message);
        this.data = data;
    }
}