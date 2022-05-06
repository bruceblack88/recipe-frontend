package solutions.adapttech.spaceshipcrud.crewmember;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solutions.adapttech.spaceshipcrud.spaceship.Spaceship;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CrewmemberController {
    CrewmemberRepository repository;

    public CrewmemberController(CrewmemberRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/crewmember/{id}")
    public ResponseEntity<Object> getCrewmember(@PathVariable Long id){
        try {
            Crewmember crewmember = repository.findById(id).get();
            return new ResponseEntity<>(crewmember, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to find crewmember", HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/crewmember")
    public Iterable<Crewmember> listAllCrewmembers(){
        return repository.findAll();
    }
    @PostMapping("/crewmember")
    public ResponseEntity<Object> createCrewMember(@RequestBody Crewmember crewmember){
        try {
            Crewmember addCrewmember = repository.save(crewmember);
            return new ResponseEntity<>(addCrewmember, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>("unable to add crewmember", HttpStatus.BAD_REQUEST);
        }
    }

    //create crewmember using number entered as the id
    @PutMapping("/crewmember/{id}")
    public ResponseEntity<Object> createCrewmember(@PathVariable Long id, @RequestBody Crewmember crewmember) {

        try {
            crewmember.setId(id);
            Crewmember newCrewmember = repository.save(crewmember);
            return new ResponseEntity<>(newCrewmember, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to create crewmember", HttpStatus.BAD_REQUEST);
        }

    }

    //update crewmember
    @PatchMapping("/crewmember/{id}")
    public ResponseEntity<Object> updateCrewmember(@PathVariable Long id, @RequestBody Map<String, Object> map) {
        try {
            Crewmember oldCrewmember = repository.findById(id).get();
            map.forEach((k, v) -> {
                switch (k) {
                    case "id":
                        oldCrewmember.setId((Long) v);
                        break;
                    case "name":
                        oldCrewmember.setName((String) v);
                        break;
                    case "morale":
                        oldCrewmember.setMorale((Integer) v);
                        break;
                }
            });
            Crewmember newCrewmember = repository.save(oldCrewmember);
            return new ResponseEntity<>(newCrewmember, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to update crewmember", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/crewmember/{id}")
    public Map<String, Long> deleteCrewmember(@PathVariable Long id){
        try {
            Map<String, Long> map = new HashMap<String, Long>();
            repository.deleteById(id);
            Long count = repository.count();
            map.put("count", count);
            return map;
        } catch (Exception e) {
            Map<String, Long> map = new HashMap<String, Long>();
            Long count = repository.count();
            map.put("Unable to delete crewmember. Current count", count);
            return map;
        }
    }

}
