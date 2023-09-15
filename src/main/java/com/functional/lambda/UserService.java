package com.functional.lambda;

public class UserService {



    public User getUser(Long id) {
        return new User(id, "Harshal No" +id, false);
    }



}
