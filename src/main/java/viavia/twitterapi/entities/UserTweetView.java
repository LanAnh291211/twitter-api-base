package viavia.twitterapi.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tweet_view")
public class UserTweetView {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweet_id")
    private Integer tweetId;

    @Column(name = "tweet_text")
    private String tweetText;

    @Column(name = "tweet_picture")
    private String tweetPicture;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tweet_date", nullable = false, updatable = false)
    private Date tweetDate;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "picture_path")
    private String picturePath;
}
