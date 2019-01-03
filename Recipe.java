///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RecipeWrangler.java
// File:             Recipe.java
// Semester:         Fall 2015
//
// Author:           Nawal Dua
// CS Login:         nawal
// Lecturer's Name:  Deb Deppler
// Lab Section:      311
//
///////////////////////////////////////////////////////////////////////////////
public class Recipe implements Comparable{
	//Fields declared here
	private String recipeName;
	private String recipeIngredients;
	private String recipeInstructions;
    //class constructor for the recipe where fields are initialized to the
	// parameters.
	public Recipe(String recipeName, String recipeIngredients,
			String recipeInstructions){
		this.recipeName = recipeName;
		this.recipeIngredients = recipeIngredients;
		this.recipeInstructions = recipeInstructions;
	}
	/**
	 * gets the name of the instance of the recipe
	 * @return the recipe name
	 */
	public String getName(){
		return recipeName;
	}
	/**
	 * gets the ingredients of the instance of the recipe
	 * @return the recipe ingredients
	 */
	public String getIngredients(){
		return recipeIngredients;
	}
	/**
	 * gets the instructions of the instance of the recipe
	 * @return the recipe instructions
	 */
	public String getInstructions(){
		return recipeInstructions;
	}
	/**
	 * sets the name of the instance of the recipe
	 * @param (recipeName) (the new name of the recipe)
	 * @return Void
	 */
	public void setName(String recipeName){
		this.recipeName = recipeName;
	}
	/**
	 * sets the ingredients of the instance of the recipe
	 * @param (recipeIngredients) (the new ingredients of the recipe)
	 * @return Void
	 */
	public void setIngredients(String recipeIngredients){
		this.recipeIngredients = recipeIngredients;
	}
	/**
	 * sets the instructions of the instance of the recipe
	 * @param (recipeInstructions) (the new intructions of the recipe)
	 * @return Void
	 */
	public void setInstructions(String recipeInstructions){
		this.recipeInstructions = recipeInstructions;
	}

	@Override
	/**
	 * An override of the default compareTo method, where a negative value is 
	 * returned if the second name greater lexicographically greater, positive 
	 * if its lexicographically less than or 0 if they are the same. 
	 *
	 * @param (otherRecipe) (the other recipe to which this a recipe will be
	 * 						 compared to)
	 * @return (description of the return value)
	 */
	public int compareTo(Object otherRecipe) {
		return this.recipeName.charAt(0)-((Recipe) otherRecipe).getName()
				.charAt(0);
	}
}
