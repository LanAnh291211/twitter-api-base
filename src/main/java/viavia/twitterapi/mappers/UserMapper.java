package viavia.twitterapi.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

import viavia.twitterapi.dtos.RegisterRequestDTO;
import viavia.twitterapi.dtos.LoginResponseDTO;
import viavia.twitterapi.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    LoginResponseDTO toResponseDTO(User login);

    @Mapping(target = "password", ignore = true)
    User fromRegisterRequestDTO(RegisterRequestDTO registerRequestDTO);
}
