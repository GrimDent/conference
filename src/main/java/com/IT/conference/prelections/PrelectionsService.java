package com.IT.conference.prelections;

import com.IT.conference.users.Users;
import com.IT.conference.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrelectionsService {

    private final PrelectionsRepository prelectionsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public PrelectionsService(PrelectionsRepository prelectionsRepository, UsersRepository usersRepository){
        this.prelectionsRepository = prelectionsRepository;
        this.usersRepository = usersRepository;
    }

    public List<Prelections> getPrelections(){
        return prelectionsRepository.findAll();
    }

    public List<Prelections> checkYourPrelections(String login) {
        Users user = usersRepository.findUserByLogin(login).get();
        return prelectionsRepository.selectJoin(user.getId());
    }

}
