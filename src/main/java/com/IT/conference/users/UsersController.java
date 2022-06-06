package com.IT.conference.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return usersService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestPart String login, @RequestPart String email) {
        usersService.addNewUser(login, email);
    }

    @PostMapping(value = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void registerToPrelection(@RequestPart String login, @RequestPart String email, @RequestPart String prelectionId) throws Exception {
        Long id = Long.parseLong(prelectionId);
        usersService.registerToPrelection(login, email, id);
    }
    @DeleteMapping(value = "/resign", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void resignFromPrelection(@RequestPart String login, @RequestPart String email, @RequestPart String prelectionId) throws Exception {
        Long id = Long.parseLong(prelectionId);
        usersService.resignFromPrelection(login, email, id);
    }
    @PostMapping(value="/update")
    public void updateMail(@RequestPart String login, @RequestPart String email){
        usersService.updateEmail(login, email);
    }
}