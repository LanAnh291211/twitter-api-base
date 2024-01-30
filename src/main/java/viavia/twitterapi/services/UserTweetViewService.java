package viavia.twitterapi.services;

import viavia.twitterapi.dtos.TweetListResponseDTO;
import viavia.twitterapi.dtos.TweetListRequestDTO;
import viavia.twitterapi.base.PagedList;

public interface UserTweetViewService {
    PagedList<TweetListResponseDTO> findPersonalAndFollowingTweet(TweetListRequestDTO tweetListRequestDTO);

    PagedList<TweetListResponseDTO> findTweetByUserId(TweetListRequestDTO tweetListRequestDTO);

    PagedList<TweetListResponseDTO> searchTweet(TweetListRequestDTO tweetListRequestDTO);
}
