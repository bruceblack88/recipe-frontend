package solutions.adapttech.spaceshipcrud.crewmember;
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
public class CrewmemberControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    CrewmemberRepository repository;

    @Test
    @Transactional
    @Rollback
    void createCrewmemberTest() throws Exception{
       Crewmember crewmember = new Crewmember( "John", 100);
       Crewmember addCrewmember = repository.save(crewmember);
       String url = String.format("/crewmember/%d", addCrewmember.getId().intValue());


        this.mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Charles\",\"morale\":50}"))
                .andExpect(jsonPath("$.id", is(addCrewmember.getId().intValue())))
                .andExpect(jsonPath("$.name", is("Charles")))
                .andExpect(jsonPath("$.morale", is(50)));

    }

    @Test
    @Transactional
    @Rollback
    void updateCrewmemberTest() throws Exception {
        Crewmember oldCrewmember = new Crewmember(3L, "Christopher", 100);
        Crewmember oldAdd = repository.save(oldCrewmember);
        this.mvc.perform(patch("/crewmember/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":3,\"name\":\"Charles\",\"morale\":100}"))
                .andExpect(jsonPath("$.name", is("Charles")));
        this.mvc.perform(patch("/crewmember/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"morale\":75}"))
                .andExpect(jsonPath("$.morale", is(75)));
    }
}
