package solutions.adapttech.todocrud;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ToDoController {
    ToDoRepository repository;

    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    //Creates a todo list entry
    @PostMapping("/todo")
    public ResponseEntity<Object> createAToDoListEntry(@RequestBody ToDo todo) {
        try {
            ToDo responseTodo = repository.save(todo);
            return new ResponseEntity<>(responseTodo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot save ToDo", HttpStatus.BAD_REQUEST);
        }
    }

    //Responds with a single todo

    @GetMapping("/todo/{id}")
    public ResponseEntity<Object> getASingleToDoItem(@PathVariable Long id) {
        try {
            ToDo responseTodo = repository.findById(id).get();
            return new ResponseEntity<>(responseTodo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot find ToDo",  HttpStatus.BAD_REQUEST);
        }
    }


    //Updates attributes of the todo
    @PatchMapping("/todo/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody Map<String, String> map) {
        try {
            ToDo oldToDo = repository.findById(id).get();
            map.forEach((k, v) -> {
                switch (k) {
                    case "description":
                        oldToDo.setDescription(v);
                        break;
                    case "priority":
                    case "high":
                    case "low":
                    case "medium":
                        oldToDo.setPriority(v);
                        break;
                    case "dueDate":
                        LocalDate newDueDate = LocalDate.parse(v);
                        oldToDo.setDueDate(newDueDate);
                        break;
                }
            });
            ToDo newToDo = repository.save(oldToDo);
            return new ResponseEntity<>(newToDo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to update ToDo", HttpStatus.BAD_REQUEST);
        }

    }


    //Deletes the todo
    @DeleteMapping("/todo/{id}")
    public HashMap<String, Long> deletesToDo(@PathVariable Long id){
        HashMap<String, Long> map = null;
            map = new HashMap();
            repository.deleteById(id);
            Long count = repository.count();
            map.put("count", count);
        return map;
    }

    @GetMapping("/todo")
    public Iterable<ToDo> getAllToDoItems() {
        return repository.findAll();
    }
}
