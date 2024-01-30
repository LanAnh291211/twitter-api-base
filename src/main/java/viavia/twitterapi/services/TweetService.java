package viavia.twitterapi.services;

import viavia.twitterapi.dtos.TweetAddRequestDTO;

public interface TweetService {
    void addTweet(TweetAddRequestDTO tweetAddRequestDTO);
}
