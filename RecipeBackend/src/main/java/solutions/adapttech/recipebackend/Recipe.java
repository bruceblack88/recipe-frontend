package solutions.adapttech.recipebackend;


import javax.persistence.*;

@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    Integer calories;

    public Recipe() {
    }

    public Recipe(String title, String description, Integer calories) {
        this.title = title;
        this.description = description;
        this.calories = calories;
    }

    public Recipe(Long id, String title, String description, Integer calories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
