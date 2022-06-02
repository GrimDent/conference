package com.IT.conference.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers(){
                return usersRepository.findAll();
    }

    public void addNewUser(Users user) {
        Optional<Users> userByEmail =  usersRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        usersRepository.save(user);
    }
}
