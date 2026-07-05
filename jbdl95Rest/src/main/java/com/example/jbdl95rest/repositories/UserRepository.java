package com.example.jbdl95rest.repositories;

import com.example.jbdl95rest.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Random;

@Repository
public class UserRepository {

    HashMap<Integer,User> hm = new HashMap<>();

    public User createUser(User user) {

        Integer id = new Random().nextInt(100);
        user.setId(id);

        hm.put(user.getId(), user);
        return user;
    }

    public User getUser(Integer id) {
        if(!hm.containsKey(id)){
            return null;
        }
        return hm.get(id);
    }

    public User update(User model) {

        hm.put(model.getId(),model);
        return model;
    }

    public User delete(Integer id, User existingUser) {

        hm.put(id,existingUser);
        return existingUser;
    }
}
