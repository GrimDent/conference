package com.IT.conference.users;

import com.IT.conference.prelections.Prelections;
import com.IT.conference.prelections.PrelectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        List<Prelections> join = prelectionsRepository.selectOne(user.getId());
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
            try{
                FileWriter fw = new FileWriter("notifications.txt");
                Map<String, String> dataToFile = new HashMap<>();
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                String formattedDate = date.format(formatter);
                dataToFile.put("date", formattedDate);
                dataToFile.put("email", user.getEmail());
                dataToFile.put("prelection", prelection.getTitle());
                fw.write(dataToFile.get("date"));
                fw.write(dataToFile.get("email"));
                fw.write(dataToFile.get("prelection"));
            }
            catch (Exception e){
                throw new Exception("error occured during sending you a notification");
            }
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

    public void updateEmail(String login, String email) {
        Users user = new Users(login, email);
        Optional<Users> userByEmail =  usersRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        Optional<Users> userByLogin =  usersRepository.findUserByLogin(user.getLogin());
        if(userByLogin.isEmpty()){
            throw new IllegalStateException("no such login");
        }
        Users confirmedLogin = usersRepository.findUserByLogin(login).get();
        confirmedLogin.setEmail(email);
        usersRepository.save(confirmedLogin);
    }
}

