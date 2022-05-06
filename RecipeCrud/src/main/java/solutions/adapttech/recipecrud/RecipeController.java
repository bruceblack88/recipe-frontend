package solutions.adapttech.recipecrud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RecipeController {
    RecipeRepository repository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.repository = recipeRepository;
    }

    //Creates a recipe entry
    @PostMapping("/recipe")
    public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
        try {
            Recipe responseRecipe = repository.save(recipe);
            return new ResponseEntity<>(responseRecipe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to create recipe", HttpStatus.BAD_REQUEST);
        }
    }

    //Responds with a single recipe
    @GetMapping("/recipe/{id}")
    public ResponseEntity<Object> getRecipe(@PathVariable Long id) {
        try {
            Recipe responseRecipe = repository.findById(id).get();
            return new ResponseEntity<>(responseRecipe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Could not find recipe", HttpStatus.BAD_REQUEST);
        }
    }

    //Update attributes of the recipe
    @PatchMapping ("/recipe/{id}")
    public ResponseEntity<Object> updateRecipe(@PathVariable Long id, @RequestBody Map<String, Object> map) {
        try {
            Recipe oldRecipe = repository.findById(id).get();
            map.forEach((k, v) -> {
                switch (k) {
                    case "description":
                        oldRecipe.setDescription((String) (v));
                        break;
                    case "instructions":
                        oldRecipe.setInstructions((String) (v));
                        break;
                    case "title":
                        oldRecipe.setTitle((String) (v));
                        break;
                    case "calories":
                        oldRecipe.setCalories((Integer) (v));
                        break;
                    case "dateCreated":
                        LocalDate date = LocalDate.parse((CharSequence) (v));
                        oldRecipe.setDateCreated(date);
                        break;
                }
            });
            Recipe newRecipe = repository.save(oldRecipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.OK);

        } catch (
                Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Unable to update recipe", HttpStatus.BAD_REQUEST);
        }
    }

//Deletes the recipe at the id
    @DeleteMapping("/recipe/{id}")
    public HashMap<String, Long> deleteRecipe(@PathVariable Long id){
        HashMap<String, Long> map = new HashMap<>();
        try {
            repository.deleteById(id);
            Long count = repository.count();
            map.put("count", count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

//List of all recipes
    @GetMapping("/recipe")
    public Iterable<Recipe> getAllRecipe(){
        return repository.findAll();
    }

}
