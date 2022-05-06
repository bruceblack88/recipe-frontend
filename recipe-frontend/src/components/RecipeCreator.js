import axios from 'axios';
import {useState} from "react";

const RecipeCreator = ({getAllRecipes}) => {
    const [userInputTitle, setUserInputTitle] = useState("");
    const [userInputDescription, setUserInputDescription] = useState("");
    const [userInputCalories, setUserInputCalories] = useState("");

    const setTitle = (event) =>{
        setUserInputTitle(event.target.value);
    }
    const setDescription = (event) =>{
        setUserInputDescription(event.target.value);
    }

    const setCalories = (event) =>{
        setUserInputCalories(event.target.value);
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        axios.post("http://localhost:8080/recipe", {
            title: userInputTitle,
            description: userInputDescription,
            calories: userInputCalories
        })
            .then(response => {
                getAllRecipes();
                setUserInputTitle("");
                setUserInputDescription("");
                setUserInputCalories("");
            });

    }

    return (
        <div className="form">

            <form onSubmit={handleSubmit}>
                <label htmlFor="recipeTitle">Add a new recipe: </label>
                <input
                    id="recipeTitle"
                    type="text"
                    value={userInputTitle}
                    placeholder="recipe title...."
                    onChange={setTitle}
                />
                <input
                    id="recipeDescription"
                    type="text"
                    value={userInputDescription}
                    placeholder="recipe description...."
                    onChange={setDescription}
                />
                <input
                    id="recipeCalorie"
                    type="text"
                    value={userInputCalories}
                    placeholder="recipe calories...."
                    onChange={setCalories}
                />

                <button type="submit">Add Recipe</button>
            </form>
        </div>
    );
}

export default RecipeCreator;