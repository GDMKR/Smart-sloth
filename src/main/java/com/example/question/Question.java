package com.example.question;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue
    private Long Id;

    @NotEmpty
    private String content;

    @NotEmpty
    private String firstResponse;
    @NotEmpty
    private String secondResponse;
    @NotEmpty
    private String thirdResponse;
    @NotEmpty
    private String fourthResponse;

    @NotEmpty
    private byte indexOfCorrectResponse;

}
