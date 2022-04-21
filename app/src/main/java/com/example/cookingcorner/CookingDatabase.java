package com.example.cookingcorner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.cookingcorner.Pojo.Recipe;
import com.example.cookingcorner.Pojo.ShoppingList;

import java.util.ArrayList;

/**
 * name: Komathy Mugunthan
 * Cooking Database
 */

public class CookingDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CookingCorner";

    public static final String TABLE_SHOPPING = "shoppingList";

    public static final String TABLE_FAVOURITE = "favouriteList";


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_PRICE = "price";

    public static final String COLUMN_FEID = "fEid";
    public static final String COLUMN_FENAME = "fEname";
    public static final String COLUMN_FEIMAGE = "fEimage";

    public static final String CREATE_SHOPPING_TABLE = "CREATE TABLE " +
            TABLE_SHOPPING + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME + " TEXT, " + COLUMN_QUANTITY + " TEXT, "  +
            COLUMN_PRICE + " TEXT)";

    public static final String CREATE_FAVOURITE_TABLE = "CREATE TABLE " +
            TABLE_SHOPPING + "(" + COLUMN_FEID + " INTEGER PRIMARY KEY," +
            COLUMN_FENAME + " TEXT, " + COLUMN_FEIMAGE + " TEXT)";


    public CookingDatabase(@Nullable Context context) {
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SHOPPING_TABLE);
        sqLiteDatabase.execSQL(CREATE_FAVOURITE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Add ShoppingList
    public void addShoppingList(ShoppingList shoppingList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

       // values.put(COLUMN_ID, shoppingList.getGid());
        values.put(COLUMN_NAME, shoppingList.getName());
        values.put(COLUMN_QUANTITY, shoppingList.getQuantity());
        values.put(COLUMN_PRICE, shoppingList.getPrice());
        db.insert(TABLE_SHOPPING, null, values);
        db.close();
        Log.d("SQL", "ShoppingList Added");
    }

    //Get ShoppingList
    public ShoppingList getShoppingList(int gid){
        SQLiteDatabase db  = this.getReadableDatabase();
        ShoppingList shoppingList = null;
        Cursor cursor = db.query(TABLE_SHOPPING,
                new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_QUANTITY,
                        COLUMN_PRICE}, COLUMN_ID + "= ?"
                , new String[]{String.valueOf(gid)},
                null, null, null);
        if(cursor.moveToFirst()){
            shoppingList = new ShoppingList(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3),
                    cursor.getString(4),
                    cursor.getString(5));
        }
        db.close();
        return shoppingList;
    }
    //Get All ShoppingList
    public ArrayList<ShoppingList> getAllShoppingList(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ShoppingList> shoppingList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SHOPPING, null);
        Log.d("SQL", "ShoppingList Table: " + cursor.getCount() + " records");
        while(cursor.moveToNext()){
            shoppingList.add(new ShoppingList(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3),
                    cursor.getString(4),
                    cursor.getString(5)
            ));
        }
        db.close();
        return shoppingList;
    }

    public int updateShoppingList(ShoppingList shoppingList){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, shoppingList.getName());
        values.put(COLUMN_QUANTITY, shoppingList.getQuantity());
        values.put(COLUMN_PRICE, shoppingList.getPrice());
        return db.update(TABLE_SHOPPING, values, COLUMN_ID + "=?",
                new String[]{String.valueOf(shoppingList.getGid())});
    }

    public void deleteShoppingList(int shoppingList){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOPPING, COLUMN_ID +  "=?",
                new String[]{String.valueOf(shoppingList)});
        db.close();
    }

//Add Favourite
    public void addFavourite(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FENAME, recipe.getStrMeal());
        values.put(COLUMN_FEIMAGE, recipe.getStrMealThumb());
        db.insert(TABLE_FAVOURITE, null, values);
        db.close();
        Log.d("SQL", "Favourite Added");
    }


    //Get All Favourite
    public ArrayList<Recipe> getAllFavourite(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Recipe> recipe = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FAVOURITE, null);
        Log.d("SQL", "FavouriteList Table: " + cursor.getCount() + " records");
        while(cursor.moveToNext()){
            recipe.add(new Recipe(
                    cursor.getString(1),
                    cursor.getString(2)
            ));
        }
        db.close();
        return recipe;
    }

}
