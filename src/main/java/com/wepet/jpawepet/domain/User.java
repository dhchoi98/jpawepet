package com.wepet.jpawepet.domain;

import com.wepet.jpawepet.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue

    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private LocalDate birthday;

    private String password;
    private String phoneNumber;
}
