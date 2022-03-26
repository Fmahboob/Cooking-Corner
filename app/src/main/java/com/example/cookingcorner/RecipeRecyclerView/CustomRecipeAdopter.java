package com.example.cookingcorner.RecipeRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingcorner.R;
import com.example.cookingcorner.Recipe;

import java.util.ArrayList;
/*
* @author Farina Mahboob
* @version 1.0
* This class has Recycler view holder
* This will hold items on createView holder
* his will hold items on bind view holder
* It will return items that are in array list

 */
public class CustomRecipeAdopter extends RecyclerView.Adapter<CustomRecipeAdopter.CustomViewHolder>{

    private ArrayList<Recipe> recipes;

    public CustomRecipeAdopter(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Recipe recipe = recipes.get(position);
        holder.recipeName.setText(recipe.getRecipeName());
        holder.recipeImage.setImageResource(recipe.getRecipeImage());
    }

    @Override
    public int getItemCount() {
        if(recipes != null){
            return recipes.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView recipeName;
        protected ImageView recipeImage;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.recipeName = itemView.findViewById(R.id.recipe_name);
            this.recipeImage = itemView.findViewById(R.id.recipe_image);
        }
    }
}
