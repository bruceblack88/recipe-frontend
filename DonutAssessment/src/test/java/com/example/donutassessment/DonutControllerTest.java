package com.example.donutassessment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class DonutControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    DonutRepository repository;

    @Test
    @Transactional
    @Rollback
    void createADonutTest() throws Exception {
        String stringDate = "2022-04-08";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        this.mvc.perform(post("/donuts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Bruce\",\"topping\":\"sprinkles\",\"expiration\":\"2022-04-08\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Bruce")))
                .andExpect(jsonPath("$.topping", is("sprinkles")))
                .andExpect(jsonPath("$.expiration", is("2022-04-08")));
    }

    @Test
    @Transactional
    @Rollback
    void getASingleDonut() throws Exception {
        String stringDate = "2022-04-08";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        Donut donut = new Donut("mega", "sprinkles", date);
        Donut saveDonut = repository.save(donut);
        String url = String.format("/donuts/%d", saveDonut.getId().intValue());
        this.mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("mega")))
                .andExpect(jsonPath("$.topping", is("sprinkles")))
                .andExpect(jsonPath("$.expiration", is("2022-04-08")))
                .andExpect(jsonPath("$.id", is(donut.getId().intValue())));

    }

    @Test
    @Transactional
    @Rollback
    void updateASingleDonut() throws Exception {
        String stringDate = "2022-04-08";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        Donut donut = new Donut("mega", "sprinkles", date);
        Donut saveDonut = repository.save(donut);
        String url = String.format("/donuts/%d", saveDonut.getId().intValue());
        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Bruce\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Bruce")));
        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"topping\":\"chocolate\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Bruce")))
                .andExpect(jsonPath("$.topping", is("chocolate")));
        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"expiration\":\"2023-04-08\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Bruce")))
                .andExpect(jsonPath("$.topping", is("chocolate")))
                .andExpect(jsonPath("$.expiration", is("2023-04-08")));
        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"mega\",\"topping\":\"marsh\",\"expiration\":\"2022-05-07\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("mega")))
                .andExpect(jsonPath("$.topping", is("marsh")))
                .andExpect(jsonPath("$.expiration", is("2022-05-07")));


    }

    @Test
    @Transactional
    @Rollback
    void deleteADonut() throws Exception {
        String stringDate = "2022-04-08";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        Donut donut = new Donut("mega", "sprinkles", date);
        Donut saveDonut = repository.save(donut);
        String url = String.format("/donuts/%d", saveDonut.getId().intValue());
        this.mvc.perform(delete(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0)));
    }

    @Test
    @Transactional
    @Rollback
    void listAllDonuts() throws Exception {
        String stringDate = "2022-04-08";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        Donut donut = new Donut("mega", "sprinkles", date);
        Donut saveDonut = repository.save(donut);
        Donut donut2 = new Donut("dough", "marsh", date);
        Donut saveDonut2 = repository.save(donut2);
        this.mvc.perform(get("/donuts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("mega")))
                .andExpect(jsonPath("$[0].topping", is("sprinkles")))
                .andExpect(jsonPath("$[0].expiration", is("2022-04-08")))
                .andExpect(jsonPath("$[1].name", is("dough")))
                .andExpect(jsonPath("$[1].topping", is("marsh")))
                .andExpect(jsonPath("$[1].expiration", is("2022-04-08")));
    }

    @Test
    @Transactional
    @Rollback
    void exceptionTests() throws Exception {
        String stringDate = "2022-04-08";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        //create exception not found
        this.mvc.perform(post("/donuts"))
                .andExpect(status().isBadRequest());
        //get exception not found
        this.mvc.perform(get("/donuts/87879"))
                .andExpect(status().isNotFound());
        //patch exception not found
        this.mvc.perform(patch("/donuts/87879"))
                .andExpect(status().isBadRequest());
        //delete exception not found
        this.mvc.perform(delete("/donuts/87879"))
                .andExpect(status().isNotFound());

    }
}
