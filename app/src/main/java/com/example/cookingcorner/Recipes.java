package com.example.cookingcorner;

import android.media.Image;
/*
@author Farina Mahboob
@version 1.0
This class will hold items that is in recycler view
 */
public class Recipes {
    private String recipeName;
    private Image recipeImage;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Image getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(Image recipeImage) {
        this.recipeImage = recipeImage;
    }
}
