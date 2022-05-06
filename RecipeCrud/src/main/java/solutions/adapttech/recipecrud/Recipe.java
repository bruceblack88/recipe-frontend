package solutions.adapttech.recipecrud;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    String instructions;
    String title;
    Integer calories;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateCreated;

    public Recipe() {
    }

    public Recipe(String description, String instructions, String title, Integer calories, LocalDate dateCreated) {
        this.description = description;
        this.instructions = instructions;
        this.title = title;
        this.calories = calories;
        this.dateCreated = dateCreated;
    }

    public Recipe(Long id, String description, String instructions, String title, Integer calories, LocalDate dateCreated) {
        this.id = id;
        this.description = description;
        this.instructions = instructions;
        this.title = title;
        this.calories = calories;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
