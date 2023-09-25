package com.study.all.lambda;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {


    private Long id;
    private String name;
    private Boolean active;

    public User(Long id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }
}
