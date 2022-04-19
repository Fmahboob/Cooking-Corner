package com.example.cookingcorner.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cookingcorner.Fragments.FavouriteFragment;
import com.example.cookingcorner.R;

public class CustomViewPageAdopter extends FragmentStateAdapter {
    public CustomViewPageAdopter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return FavouriteFragment.newInstance(R.string.tip1, R.drawable.custombackground, R.string.tipDetail1);
            case 1:
                return FavouriteFragment.newInstance(R.string.tip2, R.drawable.custombackground, R.string.tipDetail2);
            case 2:
                return FavouriteFragment.newInstance(R.string.tip3, R.drawable.custombackground, R.string.tipDetail3);
            case 3:
                 return FavouriteFragment.newInstance(R.string.tip4, R.drawable.custombackground, R.string.tipDetail4);
            case 4:
                return FavouriteFragment.newInstance(R.string.tip5, R.drawable.custombackground, R.string.tipDetail5);
        }
        return FavouriteFragment.newInstance(0,0,0);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
