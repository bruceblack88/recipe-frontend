import axios from 'axios';
import './App.css';
import Recipes from "./components/Recipes";
import RecipeCreator from "./components/RecipeCreator";
import {useEffect, useState} from "react";

function App() {
    const [recipes, setRecipes] = useState([]);

    useEffect(()=> {
        getAllRecipes();
    }, []);

    const getAllRecipes = () => {
        axios.get("http://localhost:8080/recipe")
            .then(response => {
                setRecipes(response.data)
            });
    }


    return (
        <div>
            <h1> Recipes</h1>
            <Recipes recipes={recipes} getAllRecipes={getAllRecipes}/>
            <RecipeCreator  recipes={recipes} getAllRecipes={getAllRecipes}/>

        </div>
    );
}

export default App;
