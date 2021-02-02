package com.wangzehao.microservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserServiceDAO {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;
    static {
        users.add(new User(1, "A", new Date()));
        users.add(new User(2, "B", new Date()));
        users.add(new User(3, "C", new Date()));
    }

    public List<User> finaAll(){
        return users;
    }

    public User addUser(User user){
        if(user.getId()==null){
            user.setId(usersCount+1);
        }
        users.add(user);
        usersCount++;
        return user;
    }

    public User findOne(Integer id){
        for (User u:users) {
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }

    public User deleteOne(Integer id){
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            User user = it.next();
            if(user.getId()==id){
                it.remove();
                return user;
            }
        }
        return null;
    }
}
