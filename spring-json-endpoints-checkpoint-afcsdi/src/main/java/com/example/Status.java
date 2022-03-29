package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Status {
    @JsonView(Views.Compact.class)
    //@JsonProperty("statusText")
    private String text;

    @JsonView(Views.Compact.class)
    //@JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "America/Chicago")
    private Date date;

    //@JsonGetter("statusText")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //@JsonGetter("date")
    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        SimpleDateFormat formatter =
                new SimpleDateFormat("yyyy-MM-dd hh:mm");

        try {
            this.date = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Status() {
    }

    public Status(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Status{" +
                "text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}

