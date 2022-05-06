package solutions.adapttech.recipecrud;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class RecipeControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    RecipeRepository repository;

    @Test
    @Transactional
    @Rollback
    void createRecipe() throws Exception {
        String stringDate = "2022-04-06";
        LocalDate date = LocalDate.parse(stringDate);

        this.mvc.perform(post("/recipe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\":\"beef\",\"instructions\":\"cook\",\"title\":\"steak\",\"calories\":200,\"dateCreated\":\"2022-04-06\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("beef")))
                .andExpect(jsonPath("$.instructions", is("cook")))
                .andExpect(jsonPath("$.title", is("steak")))
                .andExpect(jsonPath("$.calories", is(200)))
                .andExpect(jsonPath("$.dateCreated", is("2022-04-06")));

    }

    @Test
    @Transactional
    @Rollback
    void getRecipe() throws Exception {
        String stringDate = "2022-04-06";
        LocalDate date = LocalDate.parse(stringDate);
        Recipe recipe = new Recipe("beef", "cook", "steak", 200, date);
        Recipe recipeAdd = repository.save(recipe);
        String url = String.format("/recipe/%d", recipe.getId().intValue());
        this.mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("beef")))
                .andExpect(jsonPath("$.instructions", is("cook")))
                .andExpect(jsonPath("$.title", is("steak")))
                .andExpect(jsonPath("$.calories", is(200)))
                .andExpect(jsonPath("$.dateCreated", is("2022-04-06")));

    }

    @Test
    @Transactional
    @Rollback
    void updateRecipe() throws Exception {
        String stringDate = "2022-04-06";
        LocalDate date = LocalDate.parse(stringDate);
        Recipe recipe = new Recipe("beef", "cook", "steak", 200, date);
        Recipe recipeAdd = repository.save(recipe);

        String url = String.format("/recipe/%d", recipeAdd.getId().intValue());

        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\":\"chicken\",\"instructions\":\"fry\",\"title\":\"fried\"," +
                                "\"calories\":250,\"dateCreated\":\"2022-04-07\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("chicken")))
                .andExpect(jsonPath("$.instructions", is("fry")))
                .andExpect(jsonPath("$.title", is("fried")))
                .andExpect(jsonPath("$.calories", is(250)))
                .andExpect(jsonPath("$.dateCreated", is("2022-04-07")))
        ;
    }

    @Test
    @Transactional
    @Rollback
    void deleteRecipe() throws Exception {
        String stringDate = "2022-04-06";
        LocalDate date = LocalDate.parse(stringDate);
        Recipe recipe = new Recipe("beef", "cook", "steak", 200, date);
        Recipe recipeAdd = repository.save(recipe);

        String url = String.format("/recipe/%d", recipeAdd.getId().intValue());
        this.mvc.perform(delete(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0)));

    }

    @Test
    @Transactional
    @Rollback
    void listAllRecipe() throws Exception{
        String stringDate = "2022-04-06";
        LocalDate date = LocalDate.parse(stringDate);
        Recipe recipe = new Recipe("beef", "cook", "steak", 200, date);
        Recipe recipeAdd = repository.save(recipe);
        Recipe recipe2 = new Recipe("chicken", "cook", "steak", 200, date);
        Recipe recipeAdd2 = repository.save(recipe2);

        this.mvc.perform(get("/recipe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description", is("beef")))
                .andExpect(jsonPath("$[1].description", is("chicken")));

    }
}