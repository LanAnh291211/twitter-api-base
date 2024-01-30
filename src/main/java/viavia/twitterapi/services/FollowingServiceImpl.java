package viavia.twitterapi.services;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.base.BaseException;
import viavia.twitterapi.repositories.FollowingRepository;
import viavia.twitterapi.dtos.FollowingRequestDTO;
import viavia.twitterapi.mappers.FollowingMapper;
import viavia.twitterapi.entities.Following;

@Service
@RequiredArgsConstructor
public class FollowingServiceImpl implements FollowingService {
    private final FollowingRepository followingRepository;
    private final FollowingMapper followingMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addFollowing(FollowingRequestDTO followingRequestDTO) {
        try {
            Following following = followingMapper.fromFollowingRequestDTO(followingRequestDTO);
            followingRepository.save(following);
        } catch (Exception e) {
            throw new BaseException("fail");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteFollowing(FollowingRequestDTO followingRequestDTO) {
        try {
            followingRepository.deleteFollowingBy(
                    followingRequestDTO.getUserId(),
                    followingRequestDTO.getFollowingUserId()
            );
        } catch (Exception e) {
            throw new BaseException("fail");
        }
    }

    @Override
    public boolean checkIsFollowing(FollowingRequestDTO followingRequestDTO) {
        return followingRepository.checkIsFollowing(
                followingRequestDTO.getUserId(),
                followingRequestDTO.getFollowingUserId()
        );
    }
}
