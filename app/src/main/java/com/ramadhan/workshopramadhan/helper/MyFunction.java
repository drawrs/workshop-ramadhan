package com.ramadhan.workshopramadhan.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MyFunction extends AppCompatActivity {

    private Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = MyFunction.this;

    }

    public void intent(Class destination) {
        startActivity(new Intent(c, destination));

    }

    public void toast(String message) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();

    }
}
