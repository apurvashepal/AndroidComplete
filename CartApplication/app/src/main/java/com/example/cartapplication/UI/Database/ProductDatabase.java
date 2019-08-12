package com.example.cartapplication.UI.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.cartapplication.UI.Application.MyApplication;
import com.example.cartapplication.UI.Model.Product;

@Database(entities = {Product.class },version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    ProductDatabase db;
    MyApplication application;
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
    public abstract ProductDao productDao();
    private static ProductDatabase INSTANCE;

    static ProductDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ProductDatabase.class,
                                    "ProductDatabase").build();
                }
            }
        }
        return INSTANCE;
    }
}
