package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.hamcrest.Matchers.is;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
public class ActivitiesControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void canSendJSONFromFileCompact() throws Exception {
        String json = getJSON("/activities.json");
        //json = json.replaceAll("[\\t\\n]]", "");


        MockHttpServletRequestBuilder request = post("/activities/simplify")
                .header("Accept", "application/vnd.galvanize.compact+json")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user", is("someuser")))
                .andExpect(jsonPath("$[0].statusText", is("Just went snowboarding today!")))
                .andExpect(jsonPath("$[1].user", is("otheruser")))
                .andExpect(jsonPath("$[1].statusText", is("Great times!")));
    }

    @Test
    public void canSendJSONFromFileDetailed() throws Exception {
        String json = getJSON("/activities.json");

        MockHttpServletRequestBuilder request = post("/activities/simplify")
                .header("Accept", "application/vnd.galvanize.detailed+json")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId", is("1467")))
                .andExpect(jsonPath("$[0].email", is("personal@example.com")))
                .andExpect(jsonPath("$[1].userId", is("98732")))
                .andExpect(jsonPath("$[1].email", is("otherprimary@example.com")));

    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

    @Test
    public void getsCorrectPrimaryEmail() {
        ActivitiesService activitiesService = new ActivitiesService();
        List<Email> testEmailList = new ArrayList<>(Arrays.asList(
                new Email(52, "bob@dole.com", false),
                new Email(99, "jeff@galvanize.com", true)));

        assertEquals("jeff@galvanize.com", activitiesService.getPrimaryEmail(testEmailList));
    }

}
