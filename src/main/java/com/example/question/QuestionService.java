package com.example.question;

import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

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


    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll()
                .forEach(questions::add);
        return questions;
    }


    public List<Question> getRandomQuestions(Long numberOfQuestions){

        List<Question> questions = this.getAllQuestions();
        List<Question> copy = new ArrayList<>(questions);

        List<Question> randomQuestions = new ArrayList<>();

        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < Math.min(numberOfQuestions, questions.size()); i++) {
            randomQuestions.add( copy.remove( rand.nextInt( copy.size() ) ));
        }

        return randomQuestions;
    }
}
