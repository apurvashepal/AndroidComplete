package com.example.cartapplication.UI.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.cartapplication.R;
import com.example.cartapplication.UI.Application.Preferences;
import com.example.cartapplication.UI.Fragment.LoginFragment;

public class Aunthentication extends AppCompatActivity {

    Preferences preference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Preferences.getInstance().getBoolean("Login")){
            setContentView(R.layout.activity_recycler_view);
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        }
        else
        setContentView(R.layout.activity_main);
        loadFragment(R.id.fragment_lay ,new LoginFragment(),"Login",false);
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