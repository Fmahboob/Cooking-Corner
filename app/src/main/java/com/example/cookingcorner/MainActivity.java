package com.example.cookingcorner;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.cookingcorner.Fragments.AddEditFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cookingcorner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    NavigationView navigationView;
    NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setImageResource(R.drawable.ic_baseline_add_24);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                NavDestination currentFragment = navController.getCurrentDestination();
                if (currentFragment.getId() == R.id.nav_shop) {
                        Bundle extra = new Bundle();
                        extra.putInt(AddEditFragment.ACTION_TYPE,
                                AddEditFragment.CREATE);
                        navController
                                .navigate(R.id.addEditFragment, extra);
                }
                else if(currentFragment.getId() == R.id.nav_recipe){
                    navController.navigate(R.id.nav_recipe);
                }

            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_credit, R.id.nav_shop, R.id.nav_recipe,
                R.id.nav_tips)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination,
                                             @Nullable Bundle arguments) {
                if (destination.getId() == R.id.nav_shop || destination.getId() == R.id.nav_recipe) {
                    binding.appBarMain.fab.show();
                } else {
                    binding.appBarMain.fab.hide();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.font_size_settings:
                Log.d("OPTIONSMENU", "Font Size Clicked");
                navController.navigate(R.id.nav_settings);
                break;
            case R.id.font_color_settings:
                Log.d("OPTIONSMENU", "Font Color Clicked");
                navController.navigate(R.id.nav_settings);
                break;
            case R.id.font_style_settings:
                Log.d("OPTIONSMENU", "Font Style Clicked");
                navController.navigate(R.id.nav_settings);
                break;
            case R.id.action_timer:
                setTimer();

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private void setTimer() {
        Intent timer = new Intent(AlarmClock.ACTION_SET_TIMER);
        timer.putExtra(AlarmClock.EXTRA_MESSAGE, "Set Timer");
        timer.putExtra(AlarmClock.EXTRA_LENGTH, 800);
        timer.putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        startActivity(timer);
    }
}