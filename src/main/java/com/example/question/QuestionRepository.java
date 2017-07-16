package com.example.question;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fifa13 on 15.07.2017.
 */

public interface QuestionRepository extends CrudRepository<Question, String> {

}

