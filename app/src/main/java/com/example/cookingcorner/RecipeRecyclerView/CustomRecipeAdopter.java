package com.example.cookingcorner.RecipeRecyclerView;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingcorner.Recipes;

import java.util.ArrayList;

public class CustomRecipeAdopter extends RecyclerView.Adapter<CustomRecipeAdopter.CustomViewHolder>{

    private ArrayList<Recipes> recipes;

    public CustomRecipeAdopter(ArrayList<Recipes> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
