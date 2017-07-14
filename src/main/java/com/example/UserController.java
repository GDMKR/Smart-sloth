package com.example;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping("user/users")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}")
    public void  deleteUser(@PathVariable String username){
         userService.deleteUser(username);
    }

}
