package viavia.twitterapi.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import viavia.twitterapi.repositories.TweetRepository;
import viavia.twitterapi.dtos.TweetAddRequestDTO;
import viavia.twitterapi.mappers.TweetMapper;
import viavia.twitterapi.base.BaseException;
import viavia.twitterapi.entities.Tweet;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
    private final TweetRepository tweetRepository;
    private final TweetMapper tweetMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addTweet(TweetAddRequestDTO tweetAddRequestDTO) {
        try {
            Tweet tweet = tweetMapper.fromTweetAddRequestDTO(tweetAddRequestDTO);
            tweetRepository.save(tweet);
        } catch (Exception e) {
            throw new BaseException("fail");
        }
    }
}
