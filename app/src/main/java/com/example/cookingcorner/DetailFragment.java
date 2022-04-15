package com.example.cookingcorner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookingcorner.Pojo.Recipe;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView detailRecipeName;
    ImageView detailRecipeImage;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Recipe recipeItem;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(Recipe recipe) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        if (recipe != null)
            args.putSerializable("RECIPE", recipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey("RECIPE")) {
            recipeItem = (Recipe) getArguments().getSerializable("RECIPE");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container,false);
        detailRecipeName = view.findViewById(R.id.detailRecipeName);
        detailRecipeImage = view.findViewById(R.id.detailRecipeImage);
        setupViews();
        return view;
    }

    private void setupViews() {
        detailRecipeName.setText(recipeItem.getStrMeal());
        Picasso.get().load(recipeItem.getStrMealThumb()).into(detailRecipeImage);


    }

    @Override
    public void onPause() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        DetailFragment myFragment = (DetailFragment) getActivity().getSupportFragmentManager().findFragmentByTag("DETAILS");
        if (myFragment != null && myFragment.isVisible()) {
            transaction.remove(myFragment).commit();
            // add your code here
        }
        super.onPause();


    }
}