package com.galvanize.crudapicheckpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    UserRepository repository;

    // Test getting all users from db

    @Test
    @Transactional
    @Rollback

    public void getAllUsersTest() throws Exception {
        User user = new User("john@example.com", "1234");
        User user2 = new User("bob@example.com", "123");
        User userAdded1 = repository.save(user);
        User userAdded2 = repository.save(user2);

        this.mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(userAdded1.getId().intValue())))
                .andExpect(jsonPath("$[0].email", is("john@example.com")))
                .andExpect(jsonPath("$[0].password").doesNotExist())
                .andExpect(jsonPath("$[1].id", is(userAdded2.getId().intValue())));
    }

    // Test saving individual user
    @Test
    @Transactional
    @Rollback
    public void postNewUserTest() throws Exception {
        this.mvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"john@example.com\",\"password\": \"1234\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.email", is("john@example.com")))
                .andExpect(jsonPath("$.password").doesNotExist());
    }


    // Test getting individual users from db

    @Test
    @Transactional
    @Rollback
    public void getOneUserTest() throws Exception {
        User user = new User("john@example.com", "1234");
        User user2 = new User("bob@example.com", "123");
        User userAdded1 = repository.save(user);
        User userAdded2 = repository.save(user2);

        String path = String.format("/users/%d", userAdded1.getId().intValue());
        this.mvc.perform(get(path))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(userAdded1.getId().intValue())))
                .andExpect(jsonPath("$.email", is("john@example.com")))
                .andExpect(jsonPath("$.password").doesNotExist());
    }

    // Test updating individual user
    @Test
    @Transactional
    @Rollback
    public void updateOneUserTest() throws Exception {
        User user = new User("john@example.com", "1234");
        User user2 = new User("bob@example.com", "123");
        User userAdded1 = repository.save(user);
        User userAdded2 = repository.save(user2);

        String path1 = String.format("/users/%d", userAdded1.getId().intValue());
        this.mvc.perform(patch(path1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"john2@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("john2@example.com")))
                .andExpect(jsonPath("$.password").doesNotExist());

        String path2 = String.format("/users/%d", userAdded2.getId().intValue());
        this.mvc.perform(patch(path2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"bob2@example.com\",\"password\": \"1234\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("bob2@example.com")));

        assertEquals("1234", userAdded2.getPassword());
    }
    @Test
    @Transactional
    @Rollback
    public void postAuthenticateUserTest() throws Exception {

        User user = new User("john@example.com", "1234");
        User user2 = new User("bob@example.com", "123");
        User userAdded1 = repository.save(user);
        User userAdded2 = repository.save(user2);

        this.mvc.perform(post("/users/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"john@example.com\",\"password\": \"1234\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.id").isNumber())
                .andExpect(jsonPath("$.user.email", is("john@example.com")))
                .andExpect(jsonPath("$.authenticated", is(true)));

        this.mvc.perform(post("/users/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"john@example.com\",\"password\": \"123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.id").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.user.email").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.authenticated", is(false)));

    }

    //Endpoint 5 Test delete user
    @Test
    @Transactional
    @Rollback
    public void deleteUserTest() throws Exception {

        User user = new User("john@example.com", "1234");
        User user2 = new User("bob@example.com", "123");
        User userAdded1 = repository.save(user);
        User userAdded2 = repository.save(user2);
        String path1 = String.format("/users/%d", userAdded1.getId().intValue());

        this.mvc.perform(delete(path1))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(1)));


    }

}
