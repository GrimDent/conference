package com.IT.conference.prelections;

import com.IT.conference.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
    @GetMapping (value = "/yourPrelections")
    public List<Prelections> getYourPrelections(@RequestPart String login){
        return prelectionsService.checkYourPrelections(login);
    }

    @GetMapping(value = "/statistics")
    public Map<String, Double> getStatistics(){
        return prelectionsService.getStatistics();
    }
}
