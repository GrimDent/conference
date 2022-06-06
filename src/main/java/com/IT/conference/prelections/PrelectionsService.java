package com.IT.conference.prelections;

import com.IT.conference.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrelectionsService {

    private final PrelectionsRepository prelectionsRepository;

    @Autowired
    public PrelectionsService(PrelectionsRepository prelectionsRepository){
        this.prelectionsRepository = prelectionsRepository;
    }

    public List<Prelections> getPrelections(){
        return prelectionsRepository.findAll();
    }

    public List<Prelections> checkYourPrelections() {
        return prelectionsRepository.selectJoin();
    }

}
