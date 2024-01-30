package viavia.twitterapi.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.repositories.UserTweetViewRepository;
import viavia.twitterapi.mappers.UserTweetViewMapper;
import viavia.twitterapi.dtos.TweetListResponseDTO;
import viavia.twitterapi.dtos.TweetListRequestDTO;
import viavia.twitterapi.entities.UserTweetView;
import viavia.twitterapi.base.PagedList;

@Service
@RequiredArgsConstructor
public class UserTweetViewServiceImpl implements UserTweetViewService {
    private final UserTweetViewRepository userTweetViewRepository;
    private final UserTweetViewMapper userTweetViewMapper;

    @Override
    public PagedList<TweetListResponseDTO> findPersonalAndFollowingTweet(
            TweetListRequestDTO tweetListRequestDTO
    ) {
        Page<UserTweetView> userTweetViewPage = userTweetViewRepository.findPersonalAndFollowingTweet(
                tweetListRequestDTO.getUserId(),
                getPageRequest(tweetListRequestDTO)
        );
        return getTweetListResponseDTOs(userTweetViewPage);
    }

    @Override
    public PagedList<TweetListResponseDTO> findTweetByUserId(
            TweetListRequestDTO tweetListRequestDTO
    ) {
        Page<UserTweetView> userTweetViewPage = userTweetViewRepository.findTweetByUserId(
                tweetListRequestDTO.getUserId(),
                getPageRequest(tweetListRequestDTO)
        );
        return getTweetListResponseDTOs(userTweetViewPage);
    }

    @Override
    public PagedList<TweetListResponseDTO> searchTweet(
            TweetListRequestDTO tweetListRequestDTO
    ) {
        Page<UserTweetView> userTweetViewPage = userTweetViewRepository.searchTweet(
                tweetListRequestDTO.getQuery(),
                getPageRequest(tweetListRequestDTO)
        );
        return getTweetListResponseDTOs(userTweetViewPage);
    }

    private PageRequest getPageRequest(TweetListRequestDTO tweetListRequestDTO) {
        return PageRequest.of(tweetListRequestDTO.getPageIndex(), tweetListRequestDTO.getPageSize());
    }

    private PagedList<TweetListResponseDTO> getTweetListResponseDTOs(
            Page<UserTweetView> userTweetViewPage
    ) {
        return new PagedList<>(
                userTweetViewMapper.toTweetListResponseDTOs(userTweetViewPage.getContent()),
                userTweetViewPage.getTotalElements(),
                userTweetViewPage.getTotalPages()
        );
    }
}
