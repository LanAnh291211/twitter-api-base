package viavia.twitterapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.services.FollowingService;
import viavia.twitterapi.dtos.FollowingRequestDTO;
import viavia.twitterapi.base.SuccessResponse;

@RestController
@RequestMapping("following")
@RequiredArgsConstructor
public class FollowingController {
    private final FollowingService followingService;

    @GetMapping("user-following")
    public SuccessResponse<Void> userFollowing(
            @RequestParam(name = "op") Integer op,
            FollowingRequestDTO followingRequestDTO
    ) {
        switch (op) {
            case 1 -> followingService.createFollowing(followingRequestDTO);
            case 2 -> followingService.deleteFollowing(followingRequestDTO);
        }
        return new SuccessResponse<>(null, "following is updated");
    }

    @GetMapping("is-following")
    public SuccessResponse<Void> isFollowing(
            FollowingRequestDTO followingRequestDTO
    ) {
        boolean isFollowing = followingService.checkIsFollowing(followingRequestDTO);
        String message = isFollowing ? "is subsriber" : "isnot subscriber";
        return new SuccessResponse<>(null, message);
    }
}
