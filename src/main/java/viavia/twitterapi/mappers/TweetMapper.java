package viavia.twitterapi.mappers;

import org.mapstruct.Mapper;

import viavia.twitterapi.dtos.TweetAddRequestDTO;
import viavia.twitterapi.entities.Tweet;

@Mapper(componentModel = "spring")
public interface TweetMapper {
    Tweet fromTweetAddRequestDTO(TweetAddRequestDTO tweetAddRequestDTO);
}
