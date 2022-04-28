package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public Collection<User> findAll(){
      return users.values();
    }

    public User create(User user){
        return users.put(user.getEmail(),user);
    }

    public boolean contains (User user){
        return users.containsKey(user.getEmail());
    }

    public User findUserByEmail(String email){
        return users.get(email);
    }
}
