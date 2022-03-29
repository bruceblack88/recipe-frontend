package com.example;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

public class User {
    @JsonView(Views.Detailed.class)
    //@JsonProperty("userId")
    private long id;

    @JsonView(Views.Compact.class)
    //@JsonProperty("user")
    private String username;

    private List<Email> emails = new ArrayList<>();

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emails=" + emails +
                '}';
    }

    //@JsonGetter("userId")
    public void setId(long id) {
        this.id = id;
    }

    //@JsonGetter("user")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public User() {
    }

    public User(long id, String username, List<Email> emails) {
        this.id = id;
        this.username = username;
        this.emails = emails;
    }
}

