package com.example.cookingcorner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookingcorner.Fragments.TipsFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CookingTipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CookingTipsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int position = 0;

    public CookingTipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CookingTipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CookingTipsFragment newInstance(String param1, String param2) {
        CookingTipsFragment fragment = new CookingTipsFragment();
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

        Bundle extra = getArguments();
        CustomViewPager2Adapter adapter = new CustomViewPager2Adapter(getActivity());
        if(extra != null){
            position = extra.getInt("TIPS");
        }

        View view = inflater.inflate(R.layout.fragment_cooking_tips, container, false);
        ViewPager2 tipsViewPager = view.findViewById(R.id.tipsViewPager);
        tipsViewPager.setPageTransformer(new DepthPageTransformer());
        tipsViewPager.setAdapter(adapter);


        return view;
    }
    private class CustomViewPager2Adapter extends FragmentStateAdapter {

        public CustomViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return TipsFragment.newInstance(R.string.tip1, R.drawable.recipe, R.string.tipDetail1);
                case 1:
                    return TipsFragment.newInstance(R.string.tip2, R.drawable.cuttingboard, R.string.tipDetail2);
                case 2:
                    return TipsFragment.newInstance(R.string.tip3, R.drawable.knives, R.string.tipDetail3);
                case 3:
                    return TipsFragment.newInstance(R.string.tip4, R.drawable.drymeat, R.string.tipDetail4);
                case 4:
                    return TipsFragment.newInstance(R.string.tip5, R.drawable.dampoven, R.string.tipDetail5);

                default:
                    return TipsFragment.newInstance(0,0,0);
            }


        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

    public class DepthPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setTranslationZ(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);
                // Move it behind the left page
                view.setTranslationZ(-1f);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
    }


