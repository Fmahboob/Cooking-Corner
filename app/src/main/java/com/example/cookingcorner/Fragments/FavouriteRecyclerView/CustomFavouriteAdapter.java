package com.example.cookingcorner.Fragments.FavouriteRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingcorner.Pojo.Recipe;
import com.example.cookingcorner.R;
import com.example.cookingcorner.RecipeRecyclerView.CustomRecipeAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomFavouriteAdapter extends RecyclerView.Adapter<CustomFavouriteAdapter.CustomViewHolder>{

    private ArrayList<Recipe> recipeArrayList;
    private Context context;

    public CustomFavouriteAdapter(ArrayList<Recipe> recipeArrayList, Context context) {
        this.recipeArrayList = recipeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomFavouriteAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_favourite_recycler, parent, false);
        return new CustomFavouriteAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomFavouriteAdapter.CustomViewHolder holder, int position) {

        Recipe recipe = recipeArrayList.get(position);

        holder.recipeName.setText(recipe.getStrMeal());

        Picasso.get().load(recipe.getStrMealThumb()).into(holder.recipeImage);
    }

    @Override
    public int getItemCount() {
        if(recipeArrayList != null){
            return recipeArrayList.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView recipeName;
        protected ImageView recipeImage;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipe_name);
            recipeImage = itemView.findViewById(R.id.recipe_image);
        }
    }
}

