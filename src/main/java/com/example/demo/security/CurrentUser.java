package com.example.demo.security;


import com.example.demo.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getPhone(), user.getPassword(), AuthorityUtils.createAuthorityList("user"));
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public int getId(){
        return user.getId();
    }
}
