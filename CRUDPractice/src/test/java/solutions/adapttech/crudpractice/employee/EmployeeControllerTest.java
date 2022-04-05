package solutions.adapttech.crudpractice.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class EmployeeControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    EmployeeRepository repository;


    @Test
    @Transactional
    @Rollback
    void createEmployee() throws Exception {
        Employee employee1 = new Employee();
        employee1.setName("Bruce");
        String sDate1 = "2022-04-05";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        employee1.setDate(date1);

        this.mvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Bruce\",\"date\": \"2022-04-05\"}"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Bruce")))
                .andExpect(jsonPath("$.date", is("2022-04-05")));
        assertEquals("Bruce", employee1.getName());
        //assertEquals("2022-04-05", employee1.getDate());
    }

    @Test
    @Transactional
    @Rollback
    void getSingleEmployeeById() throws Exception {
        String sDate1 = "2022-04-05";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        Employee employee1 = new Employee("Bruce", date1);
        Employee employeeAdd = repository.save(employee1);

        String urlId = String.format("/employees/%d", employee1.getId().intValue());

        this.mvc.perform(get(urlId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(employeeAdd.getId().intValue())))
                .andExpect(jsonPath("$.name", is("Bruce")))
                .andExpect(jsonPath("$.date", is("2022-04-05")));
    }

    @Test
    @Transactional
    @Rollback
    void updateSingleEmployeeAttribute() throws Exception {
        String sDate1 = "2022-04-05";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        Employee employee1 = new Employee("Bruce", date1);
        Employee employeeAdd = repository.save(employee1);

        String urlId = String.format("/employees/%d", employee1.getId().intValue());

        this.mvc.perform(patch(urlId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John\"}"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John")));

    }

    @Test
    @Transactional
    @Rollback
    void deleteSingleEmployeeAttribute() throws Exception {
        String sDate1 = "2022-04-05";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        Employee employee1 = new Employee("Bruce", date1);
        Employee employeeAdd = repository.save(employee1);

        String urlId = String.format("/employees/%d", employeeAdd.getId().intValue());

        this.mvc.perform(delete(urlId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0)));

    }
    @Test
    @Transactional
    @Rollback
    void displayAllEmployees() throws Exception {

        String sDate1 = "2022-04-05";
        String sDate2 = "2022-04-06";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate2);
        Employee employee1 = new Employee("Bruce", date1);
        Employee employee2 = new Employee("John", date2);
        employee1.setDate(date1);
        employee2.setDate(date2);
        Employee employee1Add = repository.save(employee1);
        Employee employee2Add = repository.save(employee2);

        this.mvc.perform(get("/employees"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Bruce")))
                .andExpect(jsonPath("$[0].date", is("2022-04-05")))
                .andExpect(jsonPath("$[1].name", is("John")))
                .andExpect(jsonPath("$[1].date", is("2022-04-06")));

    }
    @Test
    public void createEmployeeClassTest() throws ParseException {
        Employee testEmployee = new Employee();
        testEmployee.setId(1L);
        testEmployee.setName("Bruce");
        String sDate1 = "2022-04-05";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        testEmployee.setDate(date1);

        assertEquals(1L,testEmployee.getId());
        assertEquals("Bruce", testEmployee.getName());
        assertEquals(date1, testEmployee.getDate());

        Employee testEmployee2 = new Employee(2L, "Jim", date1);
        assertEquals(2L,testEmployee2.getId());
        assertEquals("Jim", testEmployee2.getName());
        assertEquals(date1, testEmployee2.getDate());

    }


}