package viavia.twitterapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TweetListResponseDTO {
    private Integer tweetId;
    private String tweetText;
    private String tweetPicture;
    private Date tweetDate;
    private Integer userId;
    private String firstName;
    private String picturePath;
}
