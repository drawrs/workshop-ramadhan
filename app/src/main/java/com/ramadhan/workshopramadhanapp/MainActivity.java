package com.ramadhan.workshopramadhanapp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ramadhan.workshopramadhanapp.activity.LoginLocation;
import com.ramadhan.workshopramadhanapp.helper.MyFunction;

import java.text.SimpleDateFormat;
import java.util.Date;
public class MainActivity extends MyFunction {

    TextView tvLocation, tvDate, tvHours, tvInputLoc;
    String loginLocation;
    RecyclerView rv;

    LoginLocation.Preference preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preference = new LoginLocation.Preference(this);
        loginLocation = preference.getLocLogin();

        tvLocation = findViewById(R.id.tv_location);
        tvDate = findViewById(R.id.tv_date);
        tvHours = findViewById(R.id.tv_hours);
        rv = findViewById(R.id.recycler_view);

        //TODO 2 buat methods

    }

    private void getScheduleSholat(String detailPlaces) {

    }


    private void date() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format
                = new SimpleDateFormat("EEE, d MMM yyyy");
        final String currentDate = format.format(new Date());
        tvDate.setText(currentDate);
    }


    private void hours() {
        final Handler handler = new Handler(getMainLooper());
        handler.postDelayed(new Runnable() {
            @SuppressLint("SimpleDateFormat")
            @Override
            public void run() {
                tvHours.setText(new SimpleDateFormat("K:mm a").format(new Date()));
                handler.postDelayed(this, 1000);

            }
        }, 10);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_item, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_logout:
                logout();
                break;

            case R.id.exit:
                break;

        }
        return super.onOptionsItemSelected(item);

    }

    private void changeLocation() {

    }

    private void logout() {
        LoginLocation.Preference preference =
                new LoginLocation.Preference(MainActivity.this);
        preference.logout();
        intent(LoginLocation.class);
        finish();
    }
}
