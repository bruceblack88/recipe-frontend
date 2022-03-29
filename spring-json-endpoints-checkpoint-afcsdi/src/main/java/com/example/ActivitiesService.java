package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.*;

public class ActivitiesService {

    public String getCompactView(Activities activities) {
        List<LinkedHashMap<String, String>> compactJSON = new ArrayList<>();
        LinkedHashMap<String, String> map;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        for (int i = 0; i < activities.getActivities().size(); i++) {
            map = new LinkedHashMap<>();
            map.put("user", activities.getActivities().get(i).getUser().getUsername());
            map.put("date", formatter.format(activities.getActivities().get(i).getStatus().getDate()));
            map.put("statusText", activities.getActivities().get(i).getStatus().getText());
            compactJSON.add(map);
        }


        ObjectMapper objectMapper = new ObjectMapper();
        String jsonOutput = "";

        try {
            jsonOutput = objectMapper.writeValueAsString(compactJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonOutput;
    }

    public String getDetailedView(Activities activities) {

        List<LinkedHashMap<String, String>> compactJSON = new ArrayList<>();
        LinkedHashMap<String, String> map;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        for (int i = 0; i < activities.getActivities().size(); i++) {
            map = new LinkedHashMap<>();
            map.put("userId", String.valueOf(activities.getActivities().get(i).getUser().getId()));
            map.put("user", activities.getActivities().get(i).getUser().getUsername());
            map.put("email", getPrimaryEmail(activities.getActivities().get(i).getUser().getEmails()));
            map.put("date", formatter.format(activities.getActivities().get(i).getStatus().getDate()));
            map.put("statusText", activities.getActivities().get(i).getStatus().getText());
            compactJSON.add(map);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonOutput = "";

        try {
            jsonOutput = objectMapper.writeValueAsString(compactJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonOutput;
    }

    public String getPrimaryEmail(List<Email> emailList) {
        String primaryEmail = "";

        for (int i = 0; i < emailList.size(); i++) {
            if(emailList.get(i).isPrimary()) {
                primaryEmail = emailList.get(i).getAddress();
            }
        }

        return primaryEmail;
    }
}


