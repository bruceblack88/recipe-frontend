package solutions.adapttech.bookscrud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {
    BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }
    //List all books
    @GetMapping("/books")
    public Iterable<Book> getBookList(){

        return repository.findAll();
    }

    //Create a book
    @PostMapping("/books")
    public ResponseEntity<Object> createBook(@RequestBody Book book){
        try {
            Book responseBook = repository.save(book);
            return new ResponseEntity<>(responseBook, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>("Unable to add book", HttpStatus.NOT_FOUND);
        }
    }

    //Return a book
    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getABook(@PathVariable Long id){
        try {
            Book responseBook = repository.findById(id).get();
            return new ResponseEntity<>(responseBook, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>(String.format("Book with id: %d not found", id), HttpStatus.BAD_REQUEST);
        }
    }

    //Update attributes of the book
    @PatchMapping("/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable Long id, @RequestBody Map<String, String> map){
        try {
            Book oldBook = repository.findById(id).get();
            map.forEach((k,v)->{
                switch (k){
                    case "name":
                        oldBook.setName(v);
                        break;
                    case "publishDate":
                        try {
                            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(v);
                            oldBook.setPublishDate(newDate);
                            break;
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                }

            });
                Book newBook = repository.save(oldBook);
                return new ResponseEntity<>(newBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Book does not exist", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id){
        try {
            HashMap<String, Long> map = new HashMap<>();
            repository.deleteById(id);
            Long count = repository.count();
            map.put("count", count);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>("Book not available", HttpStatus.BAD_REQUEST);
        }
    }
}
