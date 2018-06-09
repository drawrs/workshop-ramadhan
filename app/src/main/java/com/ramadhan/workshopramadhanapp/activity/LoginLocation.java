package com.ramadhan.workshopramadhanapp.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.ramadhan.workshopramadhanapp.R;
import com.ramadhan.workshopramadhanapp.helper.MyFunction;

public class LoginLocation extends MyFunction {

    Preference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_location);

        // TODO 2 call preference
        preference = new Preference(LoginLocation.this);

    }


    //TODO 1 create class preference
    public static class Preference {

        String KEY_NAME = "NAMA";
        String PREF_NAME = "SIMPAN";
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        public Preference(Context c) {
            sharedPreferences = c.getSharedPreferences(PREF_NAME,
                    Context.MODE_PRIVATE);
        }


        public String getLocLogin() {
            return sharedPreferences.getString(KEY_NAME, null);
        }


        public void setLocLogin(String nama) {
            editor = sharedPreferences.edit();
            editor.putString(KEY_NAME, nama).apply();
        }


        public void logout() {
            editor = sharedPreferences.edit();
            editor.clear().apply();
        }
    }

}
