package solutions.adapttech.crudpractice.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {
    EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    //Create employees
    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = repository.save(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("User could not be saved", HttpStatus.BAD_REQUEST);
        }
    }

    //Read employees
    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getSingleEmployee(@PathVariable Long id) {
        try {
            Employee responseEmployee = repository.findById(id).get();
            return new ResponseEntity<>(responseEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No such user exists", HttpStatus.BAD_REQUEST);
        }
    }

    //Update employees
    @PatchMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Map<String, String> employeeName) {
        try {
            Employee oldEmployee = repository.findById(id).get();
            employeeName.forEach((k, v) -> {
                switch (k) {
                    case "name":
                        oldEmployee.setName(v);
                        break;
                    case "date":

                        try {
                            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(v);
                            oldEmployee.setDate(newDate);
                            break;
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                }

            });

            Employee newEmployee = repository.save(oldEmployee);
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("No such user", HttpStatus.BAD_REQUEST);
        }
    }

    //Delete by id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteOneEmployee(@PathVariable Long id) {
        try {
            HashMap<String, Long> responseMap = new HashMap<>();
            repository.deleteById(id);
            Long count = repository.count();
            responseMap.put("count", count);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No such User", HttpStatus.BAD_REQUEST);
        }
    }

    //List all employees
    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return this.repository.findAll();
    }

}
