package com.example.question;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue
    private Long Id;

    @NotEmpty
    private String content;

    @NotEmpty
    private String firstCase;
    @NotEmpty
    private String secondCase;
    @NotEmpty
    private String thirdCase;
    @NotEmpty
    private String fourthCase;

    private int indexOfCorrectCase;

}
