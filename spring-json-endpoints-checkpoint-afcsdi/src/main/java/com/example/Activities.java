package com.example;

import java.util.List;

public class Activities {
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public Activities() {
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
