package viavia.twitterapi.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.repositories.LoginRepository;
import viavia.twitterapi.base.BaseException;
import viavia.twitterapi.entities.Login;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Login login(String email, String password) {
        Login login = loginRepository.findByEmail(email)
                .orElseThrow(() -> new BaseException("cannot login"));

        if (!passwordEncoder.matches(password, login.getPassword())) {
            throw new BaseException("cannot login");
        }

        login.setPassword("");
        return login;
    }
}
