package com.example.cookingcorner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class CookingDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CookingCorner";

    public static final String TABLE_SHOPPING = "shoppingList";


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_PRICE = "price";

    public static final String CREATE_SHOPPING_TABLE = "CREATE TABLE " +
            TABLE_SHOPPING + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME + " TEXT, " + COLUMN_QUANTITY + " TEXT, "  +
            COLUMN_PRICE + " TEXT)";

    public CookingDatabase(@Nullable Context context) {
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SHOPPING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //ShoppingList - Add ShoppingList


    //ShoppingList - Get ShoppingList
}
