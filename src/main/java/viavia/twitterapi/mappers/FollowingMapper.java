package viavia.twitterapi.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

import viavia.twitterapi.dtos.FollowingRequestDTO;
import viavia.twitterapi.entities.Following;

@Mapper(componentModel = "spring")
public interface FollowingMapper {
    @Mapping(target = "id.userId", source = "userId")
    @Mapping(target = "id.followingUserId", source = "followingUserId")
    Following fromFollowingRequestDTO(FollowingRequestDTO followingRequestDTO);
}
