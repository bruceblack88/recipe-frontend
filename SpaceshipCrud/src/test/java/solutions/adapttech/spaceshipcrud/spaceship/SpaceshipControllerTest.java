package solutions.adapttech.spaceshipcrud.spaceship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import solutions.adapttech.spaceshipcrud.crewmember.Crewmember;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class SpaceshipControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    SpaceshipRepository repository;

    @Test
    @Transactional
    @Rollback
    void putRequestTest() throws Exception {
        Spaceship spaceship = new Spaceship("Apple", 100);
        Spaceship addSpaceship = repository.save(spaceship);
        String url = String.format("/spaceship/%d", addSpaceship.getId().intValue());

        this.mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Apollo 11\",\"fuel\":75}"))
                .andExpect(jsonPath("$.id", is(addSpaceship.getId().intValue())))
                .andExpect(jsonPath("$.name", is("Apollo 11")))
                .andExpect(jsonPath("$.fuel", is(75)));
    }

    @Test
    @Transactional
    @Rollback
    void updateSpaceship() throws Exception {
        Spaceship spaceship = new Spaceship(3L, "Voyager", 100);
        Spaceship addSpaceship = repository.save(spaceship);
        String url = String.format("/spaceship/%d", addSpaceship.getId().intValue());

        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Apollo 11\"}"))
                .andExpect(jsonPath("$.id", is(addSpaceship.getId().intValue())))
                .andExpect(jsonPath("$.name", is("Apollo 11")))
                .andExpect(jsonPath("$.fuel", is(100)));


    }

    @Test
    @Transactional
    @Rollback
    void updateSpaceshipFuel() throws Exception {
        Spaceship spaceship2 = new Spaceship(3L, "Voyager", 100);
        Spaceship addSpaceship2 = repository.save(spaceship2);
        String url = String.format("/spaceship/%d", addSpaceship2.getId().intValue());
        this.mvc.perform(patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fuel\":75}"))
                .andExpect(jsonPath("$.id", is(addSpaceship2.getId().intValue())))
                .andExpect(jsonPath("$.name", is("Voyager")))
                .andExpect(jsonPath("$.fuel", is(75)));

    }
//    @Test
//    @Transactional
//    @Rollback
//    void associateCrewmemberToSpaceship() throws Exception {
//        Spaceship spaceship = new Spaceship(3L, "Voyager", 100);
//        Crewmember crewmember = new Crewmember(3L, "Bruce", 100);
//        spaceship.setCrewmember(crewmember);
//        crewmember.setSpaceship(spaceship);
//        String url = String.format("/spaceship/%d", spaceship.getId().intValue());
//        Spaceship addSpaceship = repository.save(spaceship);
//        Crewmember addCrewmember = repository.save(crewmember);
//        this.mvc.perform(patch(url)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"fuel\":75}"))
//                .andExpect(jsonPath("$.id", is(addSpaceship.getId().intValue())))
//                .andExpect(jsonPath("$.name", is("Voyager")))
//                .andExpect(jsonPath("$.fuel", is(75)));
//    }
}
