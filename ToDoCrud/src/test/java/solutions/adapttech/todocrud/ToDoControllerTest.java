package solutions.adapttech.todocrud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class ToDoControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    ToDoRepository repository;


    @Test
    @Transactional
    @Rollback
    void createAToDoListEntry() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");

        this.mvc.perform(post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\":\"fun\",\"priority\":\"low\",\"dueDate\":\"2022-04-06\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("fun")))
                .andExpect(jsonPath("$.priority", is("low")))
                .andExpect(jsonPath("$.dueDate", is("2022-04-06")));

    }
    @Test
    @Transactional
    @Rollback
    void createAToDoListEntryException() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");

        this.mvc.perform(post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("kasjdflj"))
                .andExpect(status().isBadRequest())
             ;
    }


    @Test
    @Transactional
    @Rollback
    void getASingleToDoItem() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");
        ToDo todo = new ToDo("fun", "low", date);
        ToDo todoAdd = repository.save(todo);
        String url = String.format("/todo/%d", todoAdd.getId().intValue());
        this.mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("fun")))
                .andExpect(jsonPath("$.priority", is("low")))
                .andExpect(jsonPath("$.dueDate", is("2022-04-06")));
    }
    @Test
    @Transactional
    @Rollback
    void getASingleToDoItemException() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");
        ToDo todo = new ToDo("fun", "low", date);
        ToDo todoAdd = repository.save(todo);
        String url = String.format("/todo/%d", todoAdd.getId().intValue());
        this.mvc.perform(get("/todo/89898"))
                .andExpect(status().isBadRequest());
    }
    @Test
    @Transactional
    @Rollback
    void updateById() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");
        ToDo todo = new ToDo("fun", "low", date);
        ToDo todoAdd = repository.save(todo);
        String url = String.format("/todo/%d", todoAdd.getId().intValue());
        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\":\"wild\",\"priority\":\"low\",\"dueDate\":\"2022-04-07\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("wild")))
                .andExpect(jsonPath("$.priority", is("low")))
                .andExpect(jsonPath("$.dueDate", is("2022-04-07")));
    }
    @Test
    @Transactional
    @Rollback
    void updateByIdException() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");
        ToDo todo = new ToDo("fun", "low", date);
        ToDo todoAdd = repository.save(todo);
        String url = String.format("/todo/%d", todoAdd.getId().intValue());
        this.mvc.perform(patch("/todo/98989898")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\":\"wild\",\"priority\":\"low\",\"dueDate\":\"2022-04-07\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    @Rollback
    void deletesToDo() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");
        ToDo todo = new ToDo("fun", "low", date);
        ToDo todoAdd = repository.save(todo);
        String url = String.format("/todo/%d", todoAdd.getId().intValue());
        this.mvc.perform(delete(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0)));

    }


    @Test
    @Transactional
    @Rollback
    void getAllToDoItems() throws Exception {
        LocalDate date = LocalDate.parse("2022-04-06");
        ToDo todo = new ToDo("fun", "low", date);
        ToDo todoAdd = repository.save(todo);
        LocalDate date2 = LocalDate.parse("2022-04-07");
        ToDo todo2 = new ToDo("run", "medium", date2);
        ToDo todoAdd2 = repository.save(todo2);
        this.mvc.perform(get("/todo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description", is("fun")))
                .andExpect(jsonPath("$[0].priority", is("low")))
                .andExpect(jsonPath("$[0].dueDate", is("2022-04-06")))
                .andExpect(jsonPath("$[1].description", is("run")))
                .andExpect(jsonPath("$[1].priority", is("medium")))
                .andExpect(jsonPath("$[1].dueDate", is("2022-04-07")));

    }


}