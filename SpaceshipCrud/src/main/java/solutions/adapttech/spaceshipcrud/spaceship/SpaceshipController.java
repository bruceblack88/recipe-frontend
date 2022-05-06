package solutions.adapttech.spaceshipcrud.spaceship;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solutions.adapttech.spaceshipcrud.crewmember.Crewmember;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SpaceshipController {
    SpaceshipRepository repository;

    public SpaceshipController(SpaceshipRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/spaceship/{id}")
    public ResponseEntity<Object> getSpaceship(@PathVariable Long id) {
        try {
            Spaceship spaceship = repository.findById(id).get();
            return new ResponseEntity<>(spaceship, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to find spaceship", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/spaceship")
    public Iterable<Spaceship> listAllSpaceships() {
        return repository.findAll();
    }

    @PostMapping("/spaceship")
    public ResponseEntity<Object> createSpaceship(@RequestBody Spaceship spaceship) {
        try {
            Spaceship addSpaceship = repository.save(spaceship);
            return new ResponseEntity<>(addSpaceship, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("unable to create spaceship", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/spaceship/{id}")
    public ResponseEntity<Object> putSpaceship(@PathVariable Long id, @RequestBody Spaceship spaceship) {
        try {
            spaceship.setId(id);
            Spaceship newSpaceship = repository.save(spaceship);
            return new ResponseEntity<>(newSpaceship, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to put spaceship", HttpStatus.BAD_REQUEST);
        }


    }

    @PatchMapping("/spaceship/{id}")
    public ResponseEntity<Object> updateSpaceship(@PathVariable Long id, @RequestBody Map<String, Object> map) {
        try {
            Spaceship oldSpaceship = repository.findById(id).get();
            map.forEach((k, v) -> {
                switch (k) {
                    case "id":
                        oldSpaceship.setId((Long) v);
                        break;
                    case "name":
                        oldSpaceship.setName((String) v);
                        break;
                    case "fuel":
                        oldSpaceship.setFuel((Integer) v);
                        break;
                }
            });
            Spaceship newSpaceship = repository.save(oldSpaceship);
            return new ResponseEntity<>(newSpaceship, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to update spaceship", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/spaceshi[/{id}")
    public Map<String, Long> deleteSpaceship(@PathVariable Long id){
        try {
            Map<String, Long> map = new HashMap<String, Long>();
            repository.deleteById(id);
            Long count = repository.count();
            map.put("count", count);
            return map;
        } catch (Exception e) {
            Map<String, Long> map = new HashMap<String, Long>();
            Long count = repository.count();
            map.put("Unable to delete spaceship. Current count", count);
            return map;
        }
    }
}
