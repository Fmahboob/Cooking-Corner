package com.example.cookingcorner.ShoppingRecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingcorner.CookingDatabase;
import com.example.cookingcorner.Fragments.AddEditFragment;
import com.example.cookingcorner.Pojo.ShoppingList;
import com.example.cookingcorner.R;

import java.util.ArrayList;

/**
 * name: Komathy Mugunthan
 * Custom Shopping Adapter
 */

public class CustomShoppingAdapter extends RecyclerView.Adapter<CustomShoppingAdapter.CustomViewHolder> {
    private ArrayList<ShoppingList> shoppingArrayList;
    private Context context;

    public CustomShoppingAdapter(ArrayList<ShoppingList> shoppingArrayList, Context context) {
        this.shoppingArrayList = shoppingArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomShoppingAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_shopping_list, parent, false);
        return new CustomShoppingAdapter.CustomViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CustomShoppingAdapter.CustomViewHolder holder, int position) {
        ShoppingList shoppingList = shoppingArrayList.get(position);

        holder.name.setText(shoppingList.getName());
        holder.price.setText("$ " + String.valueOf(shoppingList.getPrice()));
        holder.quantity.setText(String.valueOf(shoppingList.getQuantity()) + " g");
      //  holder.quantity.setText((int) shoppingList.getQuantity());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extra = new Bundle();
                extra.putInt(AddEditFragment.ACTION_TYPE,
                        AddEditFragment.UPDATE);
                extra.putParcelable(AddEditFragment.SHOPPING_LIST,
                        shoppingArrayList.get(holder.getAdapterPosition()));
                Navigation.findNavController(view).
                        navigate(R.id.addEditFragment, extra);            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Yes", (dialogInterface, i) -> {
                            CookingDatabase db = new CookingDatabase(context);
                            //Delete record from database
                            db.deleteShoppingList(shoppingArrayList.get(position).getGid());
                            //Delete the record from the ArrayList
                            shoppingArrayList.remove(position);
                            //Notify the RecyclerView the item was removed
                            notifyItemRemoved(position);
                            db.close();
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(shoppingArrayList != null){
            return shoppingArrayList.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView price;
        protected TextView quantity;
        protected ImageView add;
        protected ImageView edit;
        protected ImageView delete;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            add = itemView.findViewById(R.id.add);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
