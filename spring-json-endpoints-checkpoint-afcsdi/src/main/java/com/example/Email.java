package com.example;

public class Email {
    private int id;
    private String address;
    private boolean primary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public Email() {
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", primary=" + primary +
                '}';
    }

    public Email(int id, String address, boolean primary) {
        this.id = id;
        this.address = address;
        this.primary = primary;
    }
}

