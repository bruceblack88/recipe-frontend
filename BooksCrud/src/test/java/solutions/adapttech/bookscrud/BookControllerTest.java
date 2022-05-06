package solutions.adapttech.bookscrud;

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
class BookControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    BookRepository repository;

    @Test
    @Transactional
    @Rollback
    void getBookList() throws Exception {
        String dateFormatString = "2022-04-05";
        String dateFormatString2 = "2019-04-05";
        Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString);
        Date dateFormat2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString2);
        Book book1 = new Book("Love", dateFormat);
        Book book2 = new Book("Run", dateFormat2);
        book1.setPublishDate(dateFormat);
        book2.setPublishDate(dateFormat2);
        Book bookAdd1 = repository.save(book1);
        Book bookAdd2 = repository.save(book2);

        this.mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Love")))
                .andExpect(jsonPath("$[0].id", is(bookAdd1.getId().intValue())))
                .andExpect(jsonPath("$[0].publishDate", is("2022-04-05")))
                .andExpect(jsonPath("$[1].name", is("Run")))
                .andExpect(jsonPath("$[1].id", is(bookAdd2.getId().intValue())))
                .andExpect(jsonPath("$[1].publishDate", is("2019-04-05"))
                );
    }

    @Test
    @Transactional
    @Rollback
    void getAllBadRequest() throws Exception{
        this.mvc.perform(get("/book"))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    @Rollback
    void createASingleBook() throws Exception {
        String dateFormatString = "2022-04-05";
        Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString);

        this.mvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Code\",\"publishDate\":\"2022-04-05\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Code")))
                .andExpect(jsonPath("$.publishDate", is("2022-04-05")));
        this.mvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    @Rollback
    void getABook() throws Exception {
        String dateFormatString2 = "2019-04-05";
        Date dateFormat2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString2);
        Book book2 = new Book("Run", dateFormat2);
        book2.setPublishDate(dateFormat2);
        Book bookAdd2 = repository.save(book2);

        String path = String.format("/books/%d", book2.getId().intValue());
        this.mvc.perform(get(path))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(bookAdd2.getId().intValue())))
                .andExpect(jsonPath("$.name", is("Run")))
                .andExpect(jsonPath("$.publishDate", is("2019-04-05")));

        this.mvc.perform(get("/books/89899"))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @Rollback
    void updateABook() throws Exception {
        String dateFormatString = "2022-04-05";
        Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString);
        Book book2 = new Book("Code", dateFormat);
        Book bookAdd = repository.save(book2);
        String path = String.format("/books/%d", book2.getId().intValue());
        this.mvc.perform(patch(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Jog\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Jog")));


        this.mvc.perform(patch(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"publishDate\":\"2019-04-05\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("publishDate", is("2019-04-05")));
        this.mvc.perform(patch(path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    @Transactional
    @Rollback
    void deleteBookTest() throws Exception{
        String dateFormatString = "2022-04-05";
        String dateFormatString2 = "2019-04-05";
        Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString);
        Date dateFormat2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString2);
        Book book1 = new Book("Love", dateFormat);
        Book book2 = new Book("Run", dateFormat2);
        book1.setPublishDate(dateFormat);
        book2.setPublishDate(dateFormat2);
        Book bookAdd1 = repository.save(book1);
        Book bookAdd2 = repository.save(book2);

        String path = String.format("/books/%d", book2.getId().intValue());
        this.mvc.perform(delete(path))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(1)));
        this.mvc.perform(delete(path)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    void createABookManuallyTest() throws ParseException {
        String dateFormatString = "2022-04-05";
        Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormatString);
        Book book1 = new Book();
        Book book2 = new Book(2L, "Dumb", dateFormat);
        Book book3 = new Book("Run", dateFormat);
        book1.setId(1L);
        book1.setName("Love");
        book1.setPublishDate(dateFormat);

        assertEquals(1L, book1.getId());
        assertEquals("Love", book1.getName());
        assertEquals(dateFormat, book1.getPublishDate());
        assertEquals(2L, book2.getId());
        assertEquals("Dumb", book2.getName());
        assertEquals(dateFormat, book2.getPublishDate());
        assertEquals("Run", book3.getName());
        assertEquals(dateFormat, book3.getPublishDate());

    }
}