package com.example.cookingcorner.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookingcorner.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavouriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavouriteFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final int ARG_PARAM1 = 1;
    private static final int ARG_PARAM2 = R.drawable.ic_baseline_add_24;

    private static final int ARG_PARAM3 = 2;

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;
    private int mParam3;

    public FavouriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavouriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavouriteFragment newInstance(int param1, int param2, int param3) {
        FavouriteFragment fragment = new FavouriteFragment();
        Bundle args = new Bundle();
        args.putInt(String.valueOf(ARG_PARAM1), param1);
        args.putInt(String.valueOf(ARG_PARAM2), param2);
        args.putInt(String.valueOf(ARG_PARAM2), param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(String.valueOf(ARG_PARAM1));
            mParam2 = getArguments().getInt(String.valueOf(ARG_PARAM2));
            mParam3 = getArguments().getInt(String.valueOf(ARG_PARAM3));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        if(mParam1 != 0){
            TextView tip = (TextView) view.findViewById(R.id.detailRecipeName);
            tip.setText(mParam1);
        }

        if(mParam2 != 0){
            ImageView tipImage = (ImageView) view.findViewById(R.id.detailRecipeImage);
           tipImage.setImageResource(mParam2);
        }

        if(mParam3 != 0){
            TextView tipDetail = (TextView) view.findViewById(R.id.detailRecipeName);
            tipDetail.setText(mParam1);
        }

        return view;



    }
}