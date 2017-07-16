package com.example.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long Id;

    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Invalid email address.")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "score", nullable = false)
    private Long score = Long.valueOf(0);

    @Column(name = "confirm_code")
    private String confirmCode;

//    @Column(name = "role", nullable = false)
//    @Enumerated(EnumType.STRING)
//
//    private Role role;


}
