package com.example.user.baemincopy;

import android.content.Context;
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
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.daum.mf.map.api.MapView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private FrameLayout testFL;
    private android.widget.ImageView imageView2;
    private android.widget.ImageView imageView;
    private android.widget.LinearLayout mapview;
    private NavigationView navview;
    private DrawerLayout drawerlayout;


    private LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FrameLayout testFL = (FrameLayout) findViewById(R.id.testFL);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        TextView lacationTxt = (TextView) findViewById(R.id.lacationTxt);
        Geocoder gCoder = new Geocoder(mContext, Locale.getDefault());

        double lat = 37.494158;
        double lng = 126.830503;
        List<Address> addr = null;
        try {
            addr = gCoder.getFromLocation(lat, lng, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address a = addr.get(0);
        lacationTxt.setText(a.getAdminArea()+" "+a.getLocality()+" "+a.getThoroughfare());

        BindViews();
        SetValues();
        SetUpEvents();

    }

    @Override
    public void BindViews() {
        this.drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navview = (NavigationView) findViewById(R.id.nav_view);
        this.mapview = (LinearLayout) findViewById(R.id.map_view);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.imageView2 = (ImageView) findViewById(R.id.imageView2);
        this.testFL = (FrameLayout) findViewById(R.id.testFL);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void SetUpEvents() {

    }

    @Override
    public void SetValues() {

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
