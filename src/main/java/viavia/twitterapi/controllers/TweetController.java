package viavia.twitterapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.services.UserTweetViewService;
import viavia.twitterapi.dtos.TweetListResponseDTO;
import viavia.twitterapi.dtos.TweetListRequestDTO;
import viavia.twitterapi.dtos.TweetAddRequestDTO;
import viavia.twitterapi.services.TweetService;
import viavia.twitterapi.base.SuccessResponse;
import viavia.twitterapi.base.PagedList;

@RestController
@RequestMapping("tweet")
@RequiredArgsConstructor
public class TweetController {
    private final UserTweetViewService userTweetViewService;
    private final TweetService tweetService;

    @GetMapping("add")
    public SuccessResponse<Void> addTweet(
            TweetAddRequestDTO tweetAddRequestDTO
    ) {
        tweetService.addTweet(tweetAddRequestDTO);
        return new SuccessResponse<>(null, "tweet is added");
    }

    @GetMapping("list")
    public SuccessResponse<PagedList<TweetListResponseDTO>> listTweet(
            @RequestParam(name = "op") Integer op,
            @RequestParam(name = "pageIndex", required = false, defaultValue = "0") Integer pageIndex,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            TweetListRequestDTO tweetListRequestDTO
    ) {
        tweetListRequestDTO.setPageIndex(pageIndex);
        tweetListRequestDTO.setPageSize(pageSize);

        PagedList<TweetListResponseDTO> tweetList = null;
        switch (op) {
            case 1 -> tweetList = userTweetViewService.findPersonalAndFollowingTweet(tweetListRequestDTO);
            case 2 -> tweetList = userTweetViewService.findTweetByUserId(tweetListRequestDTO);
            case 3 -> tweetList = userTweetViewService.searchTweet(tweetListRequestDTO);
        }
        return new SuccessResponse<>(tweetList, "has tweet");
    }
}
