package com.ramadhan.workshopramadhan;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tvLocation, tvDate, tvHours, tvInputLoc;
    String loginLocation;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocation = findViewById(R.id.tv_location);
        tvDate = findViewById(R.id.tv_date);
        tvHours = findViewById(R.id.tv_hours);
        rv = findViewById(R.id.recycler_view);

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

            case R.id.item_your:
                changeLocation();
                break;

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
    }
}
