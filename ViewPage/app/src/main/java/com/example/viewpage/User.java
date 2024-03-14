package com.example.viewpage;

import java.io.Serializable;

public class User implements Serializable {
    String userId, emailId;

    public User(String userId, String emailId){
        this.userId = userId;
        this.emailId = emailId;

    }
}
