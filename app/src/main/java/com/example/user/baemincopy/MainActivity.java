package com.example.user.baemincopy;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private FrameLayout testFL;
    private android.widget.ImageView imageView2;
    private android.widget.ImageView imageView;
    private NavigationView navview;
    private DrawerLayout drawerlayout;

    private LinearLayout map_view;
    private TextView lacationTxt;
    private ActionBarDrawerToggle toggle;

    private Geocoder gCoder;
    List<Address> addr = null;

    private double lat = 37.494158;
    private double lng = 126.830503;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindViews();
        SetValues();
        SetUpEvents();
    }

    @Override
    public void BindViews() {
        this.drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navview = (NavigationView) findViewById(R.id.nav_view);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.imageView2 = (ImageView) findViewById(R.id.imageView2);
        this.testFL = (FrameLayout) findViewById(R.id.testFL);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.lacationTxt = (TextView) findViewById(R.id.lacationTxt);
    }

    @Override
    public void SetUpEvents() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TestActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void SetValues() {
        navview.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        gCoder = new Geocoder(mContext, Locale.getDefault());

        try {
            addr = gCoder.getFromLocation(lat, lng, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address a = addr.get(0);
        lacationTxt.setText(a.getAdminArea()+" "+a.getLocality()+" "+a.getThoroughfare());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}
