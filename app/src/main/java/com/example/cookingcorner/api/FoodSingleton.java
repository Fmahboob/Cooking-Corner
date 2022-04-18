package com.example.cookingcorner.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class FoodSingleton {
    public static FoodSingleton instance;
    private RequestQueue requestQueue;
    private static Context context;

    private FoodSingleton(Context context){
        this.context = context;
    }

    public static FoodSingleton getInstance(Context context){
        if(instance == null){
            instance = new FoodSingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

}


