package com.example.question;

import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fifa13 on 15.07.2017.
 */
@RestController

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "question/add", method = RequestMethod.POST)
    public void addUser(@RequestBody Question question){
        questionService.addQuestion(question);
    }
}
