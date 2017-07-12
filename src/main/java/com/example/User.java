package com.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long Id;

    private String email;

}
