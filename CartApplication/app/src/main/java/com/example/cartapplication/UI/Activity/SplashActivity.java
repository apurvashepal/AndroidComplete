package com.example.cartapplication.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cartapplication.R;
import com.example.cartapplication.UI.Application.Preferences;

public class SplashActivity extends Activity {
    Preferences preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                if(Preferences.getInstance().getBoolean("Login")){
                    setContentView(R.layout.activity_recycler_view);
                    Intent intent = new Intent(SplashActivity.this, CartActivity.class);
                    startActivity(intent);
                }
                else{
                Intent mainIntent = new Intent(SplashActivity.this, Aunthentication.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
                }
            }
        },2000);

    }
}
