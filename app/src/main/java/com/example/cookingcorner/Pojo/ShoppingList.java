package com.example.cookingcorner.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class ShoppingList implements Parcelable {
    private int gid;
    private String name;
    private double quantity;
    private double price;

    public ShoppingList(){

    }

    public ShoppingList(String name, double quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public ShoppingList(int gid, String name, double quantity, double price) {
        this.gid = gid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    protected ShoppingList(Parcel in) {
        gid = in.readInt();
        name = in.readString();
        quantity = in.readDouble();
        price = in.readDouble();
    }

    public static final Creator<ShoppingList> CREATOR = new Creator<ShoppingList>() {
        @Override
        public ShoppingList createFromParcel(Parcel in) {
            return new ShoppingList(in);
        }

        @Override
        public ShoppingList[] newArray(int size) {
            return new ShoppingList[size];
        }
    };

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(gid);
        parcel.writeString(name);
        parcel.writeDouble(quantity);
        parcel.writeDouble(price);
    }


}
