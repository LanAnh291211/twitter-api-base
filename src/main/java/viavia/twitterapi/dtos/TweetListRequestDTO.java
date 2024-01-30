package viavia.twitterapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TweetListRequestDTO {
    private Integer userId;
    private String query;
    private Integer pageIndex;
    private Integer pageSize;
}
