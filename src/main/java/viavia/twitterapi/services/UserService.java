package viavia.twitterapi.services;

import viavia.twitterapi.dtos.RegisterRequestDTO;
import viavia.twitterapi.dtos.LoginResponseDTO;
import viavia.twitterapi.dtos.LoginRequestDTO;

public interface UserService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

    void register(RegisterRequestDTO registerRequestDTO);
}
