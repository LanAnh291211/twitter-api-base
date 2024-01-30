package viavia.twitterapi.services;

import viavia.twitterapi.dtos.FollowingRequestDTO;

public interface FollowingService {
    void addFollowing(FollowingRequestDTO followingRequestDTO);

    void deleteFollowing(FollowingRequestDTO followingRequestDTO);

    boolean checkIsFollowing(FollowingRequestDTO followingRequestDTO);
}
