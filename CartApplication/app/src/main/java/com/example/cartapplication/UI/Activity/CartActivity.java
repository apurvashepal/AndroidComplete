package com.example.cartapplication.UI.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cartapplication.R;
import com.example.cartapplication.UI.Fragment.ProductFragment;


public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        loadFragment(R.id.shopview , new ProductFragment(), "Product", false);

    }


    public void loadFragment(
            int containerId,
            Fragment fragment,
            String classTag,
            boolean addToBackStack
    ) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            if (addToBackStack) {
                transaction.add(containerId, fragment, classTag);
                transaction.addToBackStack(null);
            } else {
                transaction.add(containerId, fragment);
            }
            transaction.commitAllowingStateLoss();
        } catch (Exception e) {
            //TODO:: Log exception
        }
    }
}
