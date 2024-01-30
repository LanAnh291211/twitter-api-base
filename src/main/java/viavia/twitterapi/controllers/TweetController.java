package viavia.twitterapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.dtos.TweetAddRequestDTO;
import viavia.twitterapi.services.TweetService;
import viavia.twitterapi.base.SuccessResponse;

@RestController
@RequestMapping("tweet")
@RequiredArgsConstructor
public class TweetController {
    private final TweetService tweetService;

    @GetMapping("add")
    public SuccessResponse<Void> addTweet(
            TweetAddRequestDTO tweetAddRequestDTO
    ) {
        tweetService.addTweet(tweetAddRequestDTO);
        return new SuccessResponse<>(null, "tweet is added");
    }
}
