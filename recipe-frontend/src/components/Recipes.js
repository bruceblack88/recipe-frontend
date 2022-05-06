import Recipe from './Recipe';

const Recipes = ({recipes, getAllRecipes}) => {
    return (
        <>
            <table>
                <tbody>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Calories</th>
                </tr>{
                    recipes.map((recipe, index) => {
                        return <Recipe key={recipe.id} recipe={recipe} getAllRecipes={getAllRecipes} index={index}/>
                    })
                }

                </tbody>
            </table>
        </>
    );

}

export default Recipes;
