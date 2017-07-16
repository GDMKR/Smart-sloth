package com.example.security;


import com.example.user.User;

/**
 * Created by Yurii on 04.04.2017.
 */


public interface SecurityService {

    void autoLogin(String username, String password);

    boolean loginUser(String username, String password);

    User getAuthenticatedUser();

}