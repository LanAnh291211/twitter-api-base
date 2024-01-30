package viavia.twitterapi.services;

import viavia.twitterapi.entities.Login;

public interface LoginService {
    Login login(String email, String password);
}
