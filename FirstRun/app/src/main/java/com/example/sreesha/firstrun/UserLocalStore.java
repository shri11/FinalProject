package com.example.sreesha.firstrun;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sreesha on 6/17/2015.
 */
public class UserLocalStore {

    public  static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("Name", user.name);
        spEditor.putInt("Age", user.age);
        spEditor.putString("UserName", user.username);
        spEditor.putString("Password", user.password);
        spEditor.commit();
    }

    public User getUserLoggedInDetails(){
        String name = userLocalDatabase.getString("Name", "");
        int age = userLocalDatabase.getInt("Age",-1);
        String username = userLocalDatabase.getString("UserName","");
        String password = userLocalDatabase.getString("Password","");

        User storedUser = new User(name, age, username, password);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn",loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if(userLocalDatabase.getBoolean("LoggedIn", false)){
            return true;
        }
        else
        {
            return false;
        }
    }
    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
