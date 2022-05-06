package solutions.adapttech.recipebackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipeController {
    private final RecipeRepository repository;

    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    //create recipe
    @PostMapping("/recipe")
    public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe){
        try {
            Recipe newRecipe= repository.save(recipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to add recipe", HttpStatus.BAD_REQUEST);
        }
    }

    //get single recipe
    @GetMapping("/recipe/{id}")
    public ResponseEntity<Object> getSingleRecipe (@PathVariable Long id){
        try {
            Recipe recipe=repository.findById(id).get();
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to find recipe", HttpStatus.BAD_REQUEST);
        }
    }

    //patch recipe
    @PatchMapping("/recipe/{id}")
    public ResponseEntity<Object> updateRecipe(@PathVariable Long id, @RequestBody Map<String, Object> map){
        try {
            Recipe oldRecipe = repository.findById(id).get();
            map.forEach((k, v) ->{
               switch(k) {
                   case "title":
                       oldRecipe.setTitle((String) (v));
                       break;
                   case "description":
                       oldRecipe.setDescription((String) (v));
                       break;
                   case "calories":
                       oldRecipe.setCalories((Integer) (v));
                       break;
               }
            });
            Recipe newRecipe=repository.save(oldRecipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>("Unable to update recipe", HttpStatus.BAD_REQUEST);
        }
    }

    //delete recipe
    @DeleteMapping("/recipe/{id}")
    public String deleteRecipe(@PathVariable Long id){
        repository.deleteById(id);
        return "Recipe deleted";
    }


    //get all
    @GetMapping("/recipe")
    public Iterable<Recipe> getAllRecipes(){

        return repository.findAll();

    }
}
