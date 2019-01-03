///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            RecipeWrangler
// Files:            RecipeWrangler.java
//                   Recipe.java
// Semester:         Fall 2015
//
// Author:           Nawal Dua
// Email:            ndua2@wisc.edu
// CS Login:         nawal
// Lecturer's Name:  Deb Deppler
// Lab Section:      311
//
///////////////////////////////////////////////////////////////////////////////

// all class imports are here
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter; 
import java.io.FileNotFoundException;

public class RecipeWrangler {

	public static void main(String[] args) {
		//declaring the scanners, arraylist and printwriters
		Scanner scnr = new Scanner(System.in);
		Scanner scnr2;
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		PrintWriter pw;

		int input = 0;
		//starting message
		System.out.print("Recipe Wrangler 2015 \nLet us help you keep"
				+ " track of your favorite recipes.\n");
		//the menu loop
		do {
			//options being displayed
			System.out.println("Main Menu \n--------- \n1. Display recipe names"
					+ " (sorted) \n2. Display/Edit/Add a recipe \n3. Load"
					+ " recipes from a file \n4. Save recipes to a file"
					+ " \n5. Exit \nEnter choice:");
			if (scnr.hasNextInt()){
				input = scnr.nextInt();
				//if user types 1
				if (input == 1){
					if (recipeList.size() == 0){
						System.out.println("No recipes");
					}
					else {
						//display recipes
						for (int i = 0; i < recipeList.size(); i++){
							System.out.println(recipeList.get(i).getName());
						}
					}
				}
				//if user types 2
				else if (input == 2){
					int recipePosition = 3;
					System.out.println("What is the name of the recipe? ");
					if (scnr.hasNext()){
						scnr.nextLine();
						//get the name of the recipe
						String name = scnr.nextLine();
						String ingredients;
						String instructions;
						boolean hasRecipe = false;
						//check every recipe in the arraylist to see if it has
						//already been added
						for (int i = 0; i < recipeList.size(); i++){
							if (name.equalsIgnoreCase(
									recipeList.get(i).getName())){
								System.out.println("Found recipe for: " + 
										recipeList.get(i).getName());
								recipePosition = i;
								//if it has been added before, set hasRecipe to
								//true and break the loop
								hasRecipe = true;
								break;
							}
						}
						//if recipe hasn't previously been added, add the recipe
						if (hasRecipe == false){
							System.out.println("Adding recipe for: " + 
									name.toUpperCase());
							System.out.println("Enter the ingredients:");
							if (scnr.hasNext()){
								ingredients = scnr.nextLine();
								System.out.println("Enter the instructions:");
								instructions = scnr.nextLine();
								recipeList.add(new Recipe(name.toUpperCase(), 
										ingredients, instructions));
								recipeList.sort(null);
							}
						}
						//if the recipe has already been added, display the edit
						//options
						if (hasRecipe == true){
							int editOption = 0;
							do {
								System.out.println("Recipe name: " + 
										recipeList.get(recipePosition)
										.getName());
								System.out.println("Ingredients: " + 
										recipeList.get(recipePosition)
										.getIngredients());
								System.out.println("Instructions: " + 
										recipeList.get(recipePosition)
										.getInstructions());
								System.out.print("1. Edit ingredient list\n2. "
										+ "Edit instructions\n3. Done editing\n"
										+ " Enter choice: ");
								if (scnr.hasNextInt()){
									editOption = scnr.nextInt();
									scnr.nextLine();
									//if user enters 1
									if (editOption == 1){
										System.out.println("Enter the"
												+ " ingredients:");
										recipeList.get(recipePosition)
										.setIngredients(scnr.nextLine());

									}
									//if user enters 2
									if (editOption == 2){
										System.out.println("Enter the"
												+ " instructions:");
										recipeList.get(recipePosition)
										.setInstructions(scnr.nextLine());
									}
								}
							}
							while (editOption != 3);
						}
					}
				}
				//if user enters 3
				else if (input == 3){
					System.out.print("What is the filename: ");
					try {
						scnr2 = new Scanner(new File(scnr.next()));
						scnr.nextLine();
						int numRecipe = scnr2.nextInt();
						scnr2.nextLine();
						for (int i = 0; i < numRecipe; i++){
							String recipeName = scnr2.nextLine().toUpperCase();
							String recipeIngredients = scnr2.nextLine();
							String recipeInstructions = scnr2.nextLine();
							try{
								recipeList.add(new Recipe(recipeName,
										recipeIngredients, recipeInstructions));
								

							}
							catch (IndexOutOfBoundsException f){
								System.out.println(f.getMessage());
							}
						}
						for (int j = 0; j < numRecipe; j++){
							System.out.println("Added " + recipeList.get(j)
									.getName());
						}
						System.out.println("Added " + numRecipe + " "
								+ "recipes");
						recipeList.sort(null);
					}
					catch (FileNotFoundException e){
						System.out.println(e.getMessage());
					}
				}
				//if user enters 4
				else if (input == 4){
					System.out.print("Enter filename: ");
					try {
						if (scnr.hasNext()){
							String saveFileName = scnr.next();
							scnr.nextLine();
							File saveFile = new File(saveFileName);
							pw = new PrintWriter(saveFile);
							pw.print(recipeList.size() + "\r\n");
							for (int i = 0; i < recipeList.size(); i++){
								pw.print(recipeList.get(i).getName() + "\r\n");
								pw.print(recipeList.get(i).getIngredients() +
										"\r\n");
								pw.print(recipeList.get(i).getInstructions() +
										"\r\n");

							}
						}
					}
					catch (FileNotFoundException e){
						System.out.println(e.getMessage());
					}
				}
				else if (input == 5){
					System.out.println("Thanks for using RecipeWrangler!");
				}
				else {
					System.out.println("Please enter an integer between 1"
							+ " and 5");
					scnr.nextLine();
				}
			}
			else {
				System.out.println("Please enter an integer between 1 and 5");
				scnr.nextLine();
			}
		}
		while (input != 5);
		scnr.close();
		System.exit(0);
	}
}
