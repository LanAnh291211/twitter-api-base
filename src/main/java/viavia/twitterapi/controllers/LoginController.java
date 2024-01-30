package viavia.twitterapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.services.LoginService;
import viavia.twitterapi.base.SuccessResponse;
import viavia.twitterapi.entities.Login;

@RequestMapping("")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("login")
    public SuccessResponse<Login> login(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password
    ) {
        return new SuccessResponse<>(loginService.login(email, password), "pass login");
    }
}
