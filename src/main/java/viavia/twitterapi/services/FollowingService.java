package viavia.twitterapi.services;

import viavia.twitterapi.dtos.FollowingRequestDTO;

public interface FollowingService {
    void createFollowing(FollowingRequestDTO followingRequestDTO);

    void deleteFollowing(FollowingRequestDTO followingRequestDTO);

    boolean checkIsFollowing(FollowingRequestDTO followingRequestDTO);
}
