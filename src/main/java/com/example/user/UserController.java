package com.example.user;

import com.example.email.EmailService;
import com.example.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.addUser(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{emailCode}", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User user,  @PathVariable  String emailCode){
        User loginUser = userService.getUser(user.getUsername());
        if(emailCode.equals("0")){


            emailService.sendConfirmMail(loginUser);
            return new ResponseEntity<>("The confirm code was sente on your email", HttpStatus.CONTINUE);
        }
        else {
            if(!emailCode.equals(loginUser.getConfirmCode()))
                return new ResponseEntity<>("The confirm code is not correct.", HttpStatus.FORBIDDEN);

            boolean ans = securityService.loginUser(user.getUsername(), user.getPassword());
            if (!ans)
                return new ResponseEntity<>("Password incorrect or user does not exist", HttpStatus.FORBIDDEN);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentUser() {
        User user = securityService.getAuthenticatedUser();
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{username}")
    public void  deleteUser(@PathVariable String username){
         userService.deleteUser(username);
    }

    //    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public void addUser(@RequestBody User user){
//        userService.addUser(user);
//    }

}
