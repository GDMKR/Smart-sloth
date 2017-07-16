package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by fifa13 on 15.07.2017.
 */
@Service
public class UserService {

    Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public User getUser(String username){
      return userRepository.findByUsername(username);
    }

    public void deleteUser(String username) {
        userRepository.delete(username);
    }
}
