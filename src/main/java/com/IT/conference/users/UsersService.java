package com.IT.conference.users;

import com.IT.conference.prelections.Prelections;
import com.IT.conference.prelections.PrelectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PrelectionsRepository prelectionsRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, PrelectionsRepository prelectionsRepository) {
        this.usersRepository = usersRepository;
        this.prelectionsRepository = prelectionsRepository;
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


    public void registerToPrelection(String login, String email,  Long prelectionId) throws Exception {
        Users user = usersRepository.findUserByLogin(login).get();
        Users user_confirm = usersRepository.findUserByEmail(email).get();
        if(user != user_confirm){
            throw new Exception("login or email adress is incorrect");
        }
        Prelections prelection = prelectionsRepository.findById(prelectionId).get();
        user.register(prelection);
        usersRepository.save(user);
        }

    public void resignFromPrelection(String login, String email,  Long prelectionId) throws Exception {
        Users user = usersRepository.findUserByLogin(login).get();
        Users user_confirm = usersRepository.findUserByEmail(email).get();
        if(user != user_confirm){
            throw new Exception("login or email adress is incorrect");
        }
        Prelections prelection = prelectionsRepository.findById(prelectionId).get();
        user.delete(prelection);
        usersRepository.save(user);
    }
    }

