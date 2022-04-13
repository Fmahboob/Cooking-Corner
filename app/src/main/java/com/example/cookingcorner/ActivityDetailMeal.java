package com.example.cookingcorner;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityDetailMeal extends AppCompatActivity {

    public static String EXTRA_TITLE = "extra_title";
    public static String EXTRA_OVERVIEW = "extra_overview";
    public static String EXTRA_DATE_RELEASE = "extra_date_release";
    public static String EXTRA_IMAGE_MEAL = "extra_image_meal";
    public static String EXTRA_RATING = "extra_rating";
    public static String EXTRA_VOTE = "extra_vote";

    private TextView tvTitle, tvOverview, tvDateRelease, tvRating;
    private ImageView imgMeal;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_detail);
        //get intent
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String overview = getIntent().getStringExtra(EXTRA_OVERVIEW);
        String rating = getIntent().getStringExtra(EXTRA_RATING);
        String vote = getIntent().getStringExtra(EXTRA_VOTE);
        String image = getIntent().getStringExtra(EXTRA_IMAGE_MEAL);
        String dateRelease = getIntent().getStringExtra(EXTRA_DATE_RELEASE);


        tvOverview = (TextView) findViewById(R.id.detailRecipeName);
        tvDateRelease = (TextView) findViewById(R.id.detailRecipeIngredient1);
        tvRating = (TextView) findViewById(R.id.detailRecipe);
        imgMeal = (ImageView) findViewById(R.id.detailRecipeImage);

        //Format Date Release
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = date_format.parse(dateRelease);

            SimpleDateFormat new_date_format = new SimpleDateFormat("EEEE, MMM dd, yyyy");
            String date_of_release = new_date_format.format(date);
            //tvDateRelease.setText(date_of_release);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //pass value using set function
        tvTitle.setText(title);
        tvDateRelease.setText(dateRelease);
        tvOverview.setText(overview);
        tvRating.setText(rating);
        Picasso.get().load(image).into(imgMeal);
    }
}
