package com.example.cartapplication.UI.Database;

import android.content.Context;
import android.os.AsyncTask;


import com.example.cartapplication.UI.Application.MyApplication;
import com.example.cartapplication.UI.Model.Product;


import java.util.List;

public class ProductRepository {

    private ProductDao productDao;


    ProductRepository(Context context) {
    }

    public ProductRepository(MyApplication myApplication) {
        ProductDatabase db;
        db = ProductDatabase.getDatabase(myApplication);
        productDao = db.productDao();
    }

    final Product productentity = new Product();

    public void insertTask(final Product product) {

        productentity.setId(product.getId());
        productentity.setName(product.getName());
        productentity.setImage(productentity.getImage());
        productentity.setPrice(product.getPrice());
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                productDao.insertProduct(productentity);
                return null;
            }
        }.execute();
    }

    public void updateTask(Product product) {

        productentity.setId(product.getId());
        productentity.setPrice(product.getPrice());
        productentity.setImage(product.getImage());
        productentity.setName(product.getName());

    }
    public  List<Product> getAll(){
       final List<Product>  allProducts;
        new AsyncTask<Void, Void, List<Product>>() {

            @Override
            protected List<Product> doInBackground(Void... voids) {
               return  productDao.getAll();
            }
        }.execute();
        allProducts = productDao.getAll();
        return  allProducts;
   }

}


