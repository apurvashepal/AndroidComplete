package com.example.cartapplication.UI.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product extends Cart implements Parcelable{

    private int id;
    private int image;
    private String Name;
    private int price;

  public   Product(){

    }
    public Product(Parcel in) {
        id = in.readInt();
        image = in.readInt();
        Name = in.readString();
        price = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(image);
        parcel.writeString(Name);
        parcel.writeInt(price);
    }
}
