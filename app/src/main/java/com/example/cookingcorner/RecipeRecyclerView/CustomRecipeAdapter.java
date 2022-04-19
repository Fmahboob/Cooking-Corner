package com.example.cookingcorner.RecipeRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingcorner.CookingDatabase;
import com.example.cookingcorner.Pojo.Recipe;
import com.example.cookingcorner.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomRecipeAdapter extends RecyclerView.Adapter<CustomRecipeAdapter.CustomViewHolder>{

    private ArrayList<Recipe> recipeArrayList;
    private Context context;


    public CustomRecipeAdapter(ArrayList<Recipe> recipeArrayList, Context context) {
        this.recipeArrayList = recipeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_recycler_view, parent, false);
/*
        EditText fename = view.findViewById(R.id.recipe_name);
        EditText feimage = view.findViewById(R.id.recipe_image);

 */

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Recipe recipe = recipeArrayList.get(position);

        holder.recipeName.setText(recipe.getStrMeal());

        Picasso.get().load(recipe.getStrMealThumb()).into(holder.recipeImage);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CookingDatabase cookingDatabase = new CookingDatabase(context);
                cookingDatabase.addFavourite(recipe);
                Toast.makeText(context, "Favourite Added", Toast.LENGTH_LONG).show();
            }
        });
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
        protected ImageView add;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipe_name);
            recipeImage = itemView.findViewById(R.id.recipe_image);
            add = itemView.findViewById(R.id.add);
        }
    }
}
