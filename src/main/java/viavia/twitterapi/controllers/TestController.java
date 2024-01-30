package viavia.twitterapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import viavia.twitterapi.base.SuccessResponse;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("ping")
    public SuccessResponse<String> login() {
        return new SuccessResponse<>("ping");
    }
}
