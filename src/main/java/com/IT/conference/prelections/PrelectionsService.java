package com.IT.conference.prelections;

import org.springframework.beans.factory.annotation.Autowired;
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
}
