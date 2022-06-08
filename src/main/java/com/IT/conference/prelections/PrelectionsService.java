package com.IT.conference.prelections;

import com.IT.conference.users.Users;
import com.IT.conference.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return prelectionsRepository.selectOne(user.getId());
    }

    public Map<String, Double> getStatistics(){
        List<Prelections> fullList = prelectionsRepository.selectAll();
        Map<String, Double> results = new HashMap<>();
        if(fullList.size() == 0){
            results.put("there are no data", 0.0);
            return results;
        }
        Double x = (double) (1 / fullList.size() * 100);
        for(int i = 0; i < fullList.size(); i++){
            String title = fullList.get(i).getTitle();
            String thematicPath = fullList.get(i).getThematic_path();
            if(results.containsKey(title)){
                results.put(title, results.get(title)+x);
            }
            else{
                results.put(title, x);
            }
            if(results.containsKey(thematicPath)){
                results.put(thematicPath, results.get(thematicPath)+x);
            }
            else{
                results.put(thematicPath, x);
            }
        }
        return results;
    }

}
