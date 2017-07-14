package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping("users")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{username}")
    public void  deleteUser(@PathVariable String username){
         userService.deleteUser(username);
    }

}
