package com.example.cartapplication.UI.Application;


import android.content.Context;
import android.content.SharedPreferences;



public class Preferences {



    private static Preferences appPreferences;
    private static final String PREF_NAME = "application_pref";
    public static boolean Login =true;


    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static Context context;



    private Preferences() {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }



    public static void init(Context context) {
        Preferences.context =  context;
    }



    public static Preferences getInstance() {
        if (appPreferences == null) {
            appPreferences = new Preferences();
        }

        return appPreferences;
    }



    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }



    public String getString(String  key) {
        return sharedPreferences.getString(key, null);
    }



    public void putInteger(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }



    public int getInteger(String key) {
        return sharedPreferences.getInt(key,0);
    }

    public void setBoolean(String name,boolean value){
       editor.putBoolean(name,value);
       editor.apply();
    }

    public Boolean getBoolean(String name){
        return sharedPreferences.getBoolean(name,true);

    }

    public void setFloat(String name,float value){
        editor.putFloat(name,value);
        editor.apply();
    }

    public float getFloat(String name){

        return sharedPreferences.getFloat(name,1);

    }

    public void setLong(String name,long value){
        editor.putLong(name,value);
        editor.apply();
    }

    public long getLong(String name){
        return sharedPreferences.getLong(name,0);

    }

}
