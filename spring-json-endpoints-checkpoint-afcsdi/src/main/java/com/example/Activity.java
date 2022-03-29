package com.example;

public class Activity {
    private User user;
    private Status status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Activity(User user, Status status) {
        this.user = user;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "user=" + user +
                ", status=" + status +
                '}';
    }

    public Activity() {
    }
}

