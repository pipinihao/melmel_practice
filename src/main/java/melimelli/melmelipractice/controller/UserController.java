package melimelli.melmelipractice.controller;

import melimelli.melmelipractice.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private Map<String,User> userMap;

    @PostConstruct
    public void init(){
        userMap = new HashMap<>();
        userMap.put("1",new User("홍길동","18"));
        userMap.put("2",new User("홍길두","19"));
        userMap.put("3",new User("홍길뷰","10"));
        userMap.put("4",new User("홍길윺","17"));
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id){
        return userMap.get(id);
    }
}
