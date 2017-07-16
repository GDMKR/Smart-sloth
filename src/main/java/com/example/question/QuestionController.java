package com.example.question;

import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fifa13 on 15.07.2017.
 */
@RestController

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/question/add", method = RequestMethod.POST)
    public void addUser(@RequestBody Question question){
        questionService.addQuestion(question);
    }

    @RequestMapping("/question/{numberOfQuestions}")
    public List<Question> getQuestion(@PathVariable Long numberOfQuestions){
        return questionService.getRandomQuestions(numberOfQuestions);
    }
}
