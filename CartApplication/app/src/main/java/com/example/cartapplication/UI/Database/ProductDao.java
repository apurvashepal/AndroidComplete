package com.example.cartapplication.UI.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cartapplication.UI.Model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insertProduct(Product Product);

    @Delete
    void DeleteProduct (Product product);

    @Query("SELECT * FROM Product")
    List<Product> getAll();

    @Update
    void updateProduct(Product product);

}
