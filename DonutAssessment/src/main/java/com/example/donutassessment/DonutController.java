package com.example.donutassessment;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DonutController {
    DonutRepository repository;

    public DonutController(DonutRepository repository) {
        this.repository = repository;
    }

    //Creates a donut using PostMapping
    @PostMapping("/donuts")
    public ResponseEntity<Object> createASingleDonut(@RequestBody Donut donut) {
        try {
            Donut newDonut = repository.save(donut);
            return new ResponseEntity<>(newDonut, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to add donut", HttpStatus.BAD_REQUEST);
        }

    }

    //Responds with a single donut using GetMapping
    @GetMapping("/donuts/{id}")
    public ResponseEntity<Object> getASingleDonut(@PathVariable Long id) {
        try {
            Donut donut = repository.findById(id).get();
            return new ResponseEntity<>(donut, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to find donut with id", HttpStatus.NOT_FOUND);
        }

    }

    //Updates attributes of the donut using a PatchMapping
    @PatchMapping("/donuts/{id}")
    public ResponseEntity<Object> updateDonut(@PathVariable Long id, @RequestBody Map<String, String> map) {
        try {
            Donut oldDonut = repository.findById(id).get();
            map.forEach((k, v) -> {
                switch (k) {
                    case "name":
                        oldDonut.setName(v);
                        break;
                    case "topping":
                        oldDonut.setTopping(v);
                        break;
                    case "expiration":
                        try {
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(v);
                            oldDonut.setExpiration(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;

                }
            });
            Donut newDonut = repository.save(oldDonut);
            return new ResponseEntity<>(newDonut, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to update donut", HttpStatus.BAD_REQUEST);
        }
    }

    //Delete a single donut using DeleteMapping
    @DeleteMapping("/donuts/{id}")
    public ResponseEntity<Object> deleteASingleDonut(@PathVariable Long id){
        try {
            HashMap<String, Long> map = new HashMap<>();
            repository.deleteById(id);
            Long count = repository.count();
            map.put("count", count);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to delete the donut", HttpStatus.NOT_FOUND);
        }
    }

    //Responds with a list of all donuts using GetMapping
    @GetMapping("/donuts")
    public Iterable<Donut> listAllDonuts(){
        return repository.findAll();
    }

}
