package com.guidetoaddis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "Pref";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_UID = "userid";
    public static final String KEY_NAME = "username";
    public static final String KEY_MAIL = "email";

    public SessionManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String username, String email, String token){

        editor.putBoolean(IS_LOGIN, true);
        //editor.putInt(KEY_EID, eid);
        editor.putString(KEY_NAME, username);
        editor.putString(KEY_MAIL, email);
        editor.putString("TO_KEN", token);

        editor.commit();
    }

  /*  public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);
        }
    }*/

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put("SESNAME", pref.getString(KEY_NAME, null));
        user.put(KEY_MAIL, pref.getString(KEY_MAIL, null));
        // return user
        user.put("TOKEN", pref.getString("TO_KEN", null));
        return user;
    }

    ///////////////////

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    //////////////////

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }


}