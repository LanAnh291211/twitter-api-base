package viavia.twitterapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

import viavia.twitterapi.dtos.LoginResponseDTO;
import viavia.twitterapi.dtos.LoginRequestDTO;
import viavia.twitterapi.dtos.RegisterRequestDTO;
import viavia.twitterapi.services.UserService;
import viavia.twitterapi.base.SuccessResponse;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService loginService;

    @GetMapping("login")
    public SuccessResponse<LoginResponseDTO> login(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password
    ) {
        LoginRequestDTO loginRequestDTO =
                LoginRequestDTO.builder().email(email).password(password).build();

        return new SuccessResponse<>(loginService.login(loginRequestDTO), "pass login");
    }

    @GetMapping("register")
    public SuccessResponse<Void> register(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "picturePath") String picturePath
    ) {
        RegisterRequestDTO registerRequestDTO = RegisterRequestDTO.builder()
                .firstName(firstName)
                .email(email)
                .password(password)
                .picturePath(picturePath)
                .build();
        loginService.register(registerRequestDTO);
        return new SuccessResponse<>(null, "user is added");
    }
}
