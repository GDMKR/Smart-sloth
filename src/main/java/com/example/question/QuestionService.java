package com.example.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fifa13 on 15.07.2017.
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }
}
