package viavia.twitterapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TweetAddRequestDTO {
    private int userId;
    private String tweetText;
    private String tweetPicture;
}
