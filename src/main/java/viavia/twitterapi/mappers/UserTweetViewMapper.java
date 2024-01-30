package viavia.twitterapi.mappers;

import org.mapstruct.Mapper;

import viavia.twitterapi.dtos.TweetListResponseDTO;
import viavia.twitterapi.entities.UserTweetView;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserTweetViewMapper {
    TweetListResponseDTO toTweetListResponseDTO(UserTweetView userTweetView);

    List<TweetListResponseDTO> toTweetListResponseDTOs(List<UserTweetView> userTweetView);
}
