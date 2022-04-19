package com.example.cookingcorner.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cookingcorner.Pojo.Recipe;
import com.example.cookingcorner.R;
import com.example.cookingcorner.RecipeRecyclerView.CustomRecipeAdapter;
import com.example.cookingcorner.api.FoodSingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * name: Komathy Mugunthan
 * Recipe Fragment
 */

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeFragment extends Fragment {
    ArrayList<Recipe> recipeArrayList;
    Context context;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeFragment newInstance(String param1, String param2) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recipeList);
        Recipe recipe = new Recipe();
        recipeArrayList = new ArrayList<>();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        String url =
                "https://www.themealdb.com/api/json/v1/1/search.php?s=a";

        //Make a request
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray jsonArray = response.getJSONArray("meals");

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject mainObject = jsonArray.getJSONObject(i);
                                recipe.setStrMeal(mainObject.getString("strMeal"));
                                recipe.setStrMealThumb(mainObject.getString("strMealThumb"));
                                recipe.setStrCategory(mainObject.getString("strCategory"));
                                recipe.setStrInstructions(mainObject.getString("strInstructions"));
                                recipeArrayList.add(new Recipe(mainObject.getString("strMeal"), mainObject.getString("strMealThumb"), mainObject.getString("strCategory"), mainObject.getString("strInstructions")));

                                Log.d("RECIPE", mainObject.getString("strMeal"));
                                Log.d("RECIPE", mainObject.getString("strMealThumb"));

                                CustomRecipeAdapter adopter = new CustomRecipeAdapter(recipeArrayList, getContext());
                                recyclerView.setAdapter(adopter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                                boolean grid = sharedPreferences.getBoolean("grid", false);

                                if(grid){
                                    GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
                                    recyclerView.setLayoutManager(layoutManager);
                                }
                                else {
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                                    recyclerView.setLayoutManager(layoutManager);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("VOLLEY_ERROR", error.getLocalizedMessage());
                    }
                });

        FoodSingleton.getInstance(getContext()).getRequestQueue().add(request);

        return view;

    }


}