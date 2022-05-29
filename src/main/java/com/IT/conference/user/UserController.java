package com.IT.conference.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    @GetMapping
    public List<User> GetUsers(){
        return List.of(
                new User(
                        1L,
                        "sampleLogin",
                        "sample.mail@gmail.com"
                )
        );
    }
}
