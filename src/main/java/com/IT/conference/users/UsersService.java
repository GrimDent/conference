package com.IT.conference.users;

import com.IT.conference.prelections.Prelections;
import com.IT.conference.prelections.PrelectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
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

    public void addNewUser(String login, String email) {
        Users user = new Users(login, email);
        Optional<Users> userByEmail =  usersRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        usersRepository.save(user);
    }

    public boolean check5(Long prelectionId){
        Long i = prelectionsRepository.countUsersInPrelection(prelectionId);
        if(i < 5){
            return true;
        }
        else{
            return false;
        }
    }

    public void registerToPrelection(String login, String email,  Long prelectionId) throws Exception {
        Users user = usersRepository.findUserByLogin(login).get();
        Users user_confirm = usersRepository.findUserByEmail(email).get();
        Prelections prelection = prelectionsRepository.findById(prelectionId).get();
        List<Prelections> join = prelectionsRepository.selectJoin(user.getId());
        for(int i = 0; i<join.size(); i++){
            if(Objects.equals(prelection.getStart_hour(), join.get(i).getStart_hour())){
                throw new Exception("You have prelection at this time already");
            }
        }
        if(user != user_confirm){
            throw new Exception("login or email adress is incorrect");
        }
        if(check5(prelection.getId())){
            user.register(prelection);
            usersRepository.save(user);
            return;
        }
            throw new Exception("There are 0 tickets left");
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

