package com.example.cookingcorner;

import android.media.Image;
/*
@author Farina Mahboob
@version 1.0
This class will hold items that is in recycler view
 */
public class Recipe {
    private String recipeName;
    private int recipeImage;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }

    public Recipe(String recipeName, int recipeImage) {
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }
}
