import axios from "axios";
import {useState} from "react";
import DeleteForeverIcon from '@mui/icons-material/DeleteForever';
import EditIcon from '@mui/icons-material/Edit';


const Recipe = ({recipe, getAllRecipes, index}) => {
    const [isEditing, setIsEditing] = useState(false);
    
    const handleClick = () =>{
        axios.delete("http://localhost:8080/recipe/" + recipe.id)
            .then(response =>getAllRecipes());
    }

    return (
        <>
            <tr>
                <td> {index+1} </td>
                <td>🍽️ {recipe.title} </td>
                <td>🧑‍🍳 {recipe.description}</td>
                <td>⚡ {recipe.calories}</td>
                <EditIcon />
                <DeleteForeverIcon 
                    onClick={handleClick}
                    style={{color: "red"}} 
                />
            </tr>


        </>
    );

}
export default Recipe;