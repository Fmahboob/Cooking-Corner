package com.example.cookingcorner.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.cookingcorner.CookingDatabase;
import com.example.cookingcorner.Pojo.ShoppingList;
import com.example.cookingcorner.R;

/**
 * name: Komathy Mugunthan
 * AddEdit Fragment
 */

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddEditFragment extends Fragment {
    ShoppingList shoppingList;
    public static final int UPDATE = 1;
    public static final int CREATE = 2;
    public static final String SHOPPING_LIST = "Shopping_list";
    public static final String ACTION_TYPE = "action_type";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddEditFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddEditFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddEditFragment newInstance(String param1, String param2) {
        AddEditFragment fragment = new AddEditFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_edit, container, false);

        EditText name = view.findViewById(R.id.ingredientName);
        EditText price = view.findViewById(R.id.ingredientPrice);
        EditText quantity = view.findViewById(R.id.ingredientQuantity);
        Button submit = view.findViewById(R.id.submitButton);

        if(getArguments() != null){
            if(getArguments().getInt(ACTION_TYPE) == UPDATE){
                shoppingList = getArguments().getParcelable(SHOPPING_LIST);
                submit.setText("UPDATE INGREDIENTS");
                if(shoppingList != null){
                    name.setText(shoppingList.getName());
                    price.setText(shoppingList.getPrice()+"");
                    quantity.setText(shoppingList.getQuantity()+"");
                }
            }
            else{
                shoppingList = new ShoppingList();
                submit.setText("CREATE INGREDIENTS");
            }
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shoppingList.setName(name.getText().toString());
                    shoppingList.setPrice(Double.parseDouble(price.getText().toString()));
                    shoppingList.setQuantity(Double.parseDouble(quantity.getText().toString()));

                    if (view.requestFocus()) {
                        InputMethodManager imm = (InputMethodManager)
                                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }

                    CookingDatabase cookingDatabase = new CookingDatabase(getContext());
                    if(getArguments().getInt(ACTION_TYPE) == UPDATE){
                        cookingDatabase.updateShoppingList(shoppingList);
                    } else if (getArguments().getInt(ACTION_TYPE) == CREATE){
                        cookingDatabase.addShoppingList(shoppingList);
                    }
                    cookingDatabase.close();
                    Navigation.findNavController(view).popBackStack();
                }
            });
        }


        return view;
    }
}