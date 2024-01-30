package viavia.twitterapi.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import viavia.twitterapi.repositories.UserRepository;
import viavia.twitterapi.dtos.RegisterRequestDTO;
import viavia.twitterapi.dtos.LoginResponseDTO;
import viavia.twitterapi.dtos.LoginRequestDTO;
import viavia.twitterapi.mappers.UserMapper;
import viavia.twitterapi.base.BaseException;
import viavia.twitterapi.entities.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new BaseException("cannot login"));

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new BaseException("cannot login");
        }

        return userMapper.toResponseDTO(user);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void register(RegisterRequestDTO registerRequestDTO) {
        Optional<User> userDb = userRepository.findByEmail(registerRequestDTO.getEmail());
        if (userDb.isPresent()) {
            throw new BaseException("user is exists");
        }

        User user = userMapper.fromRegisterDTO(registerRequestDTO);
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        userRepository.save(user);
    }
}
