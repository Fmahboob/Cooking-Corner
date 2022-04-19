package com.example.cookingcorner.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.cookingcorner.R;

/**
 * name: Komathy Mugunthan
 * Credit Fragment
 */

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreditFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreditFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditFragment newInstance(String param1, String param2) {
        CreditFragment fragment = new CreditFragment();
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
        View view = inflater.inflate(R.layout.fragment_credit, container, false);

        TextView creditPageTitle = view.findViewById(R.id.creditPageTitle);
        Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.credit_animation);

        creditPageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creditPageTitle.startAnimation(animation1);
            }
        });

        TextView textView2 = view.findViewById(R.id.textView2);
        Animation animation2 = AnimationUtils.loadAnimation(getContext(), R.anim.anim_out);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.startAnimation(animation2);
            }
        });

        TextView textView3 = view.findViewById(R.id.textView3);
        Animation animation3 = AnimationUtils.loadAnimation(getContext(), R.anim.anim_back_out);

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView3.startAnimation(animation3);
            }
        });

        TextView textView4 = view.findViewById(R.id.textView4);
        Animation animation4 = AnimationUtils.loadAnimation(getContext(), R.anim.anim_back_in);

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView4.startAnimation(animation4);
            }
        });


        return view;
    }
}