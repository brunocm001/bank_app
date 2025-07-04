package ca.test.bankapp.controller;

import ca.test.bankapp.dto.UserRegisterDTO;
import ca.test.bankapp.entity.User;
import ca.test.bankapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public boolean register(@RequestBody UserRegisterDTO userRegisterDTO) {
        User user = this.userService.createUser(userRegisterDTO);
        return user != null && user.getId() != null;
    }

}
