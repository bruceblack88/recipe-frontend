package solutions.adapttech.todocrud;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    void createToDoManually() {
        ToDo toDo1 = new ToDo();
        toDo1.setId(1L);
        toDo1.setDescription("fun");
        toDo1.setPriority("low");
        LocalDate date = LocalDate.parse("2022-04-05");
        toDo1.setDueDate(date);
        assertEquals(1L, toDo1.getId());
        assertEquals("fun", toDo1.getDescription());
        assertEquals("low", toDo1.getPriority());
        assertEquals(date, toDo1.getDueDate());
    }
}
