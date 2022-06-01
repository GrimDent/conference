package com.IT.conference.prelections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/prelections")
public class PrelectionsController {

    private final PrelectionsService prelectionsService;

    @Autowired
    public PrelectionsController(PrelectionsService prelectionsService){
        this.prelectionsService = prelectionsService;
    }
    @GetMapping
    public List<Prelections> getPrelections(){
        return prelectionsService.getPrelections();
    }
}
