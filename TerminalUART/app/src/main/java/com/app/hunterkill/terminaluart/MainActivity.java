package com.app.hunterkill.terminaluart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//

//        navigationView.setNavigationItemSelectedListener(this);
//        System.out.println("Create");
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        // like shared preferences
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        // add new layer to placeHolder layer (de len)
//        fragmentTransaction.add(R.id.drawer_layout, new TerminalFragment());
//
//        // commit the change.
//        fragmentTransaction.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain, new TerminalFragment(), "terminal").commit();


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        System.out.println(id);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_terminal) {
            Toast.makeText(this, "nav_terminal", Toast.LENGTH_SHORT).show();
            System.out.println("nav_terminal");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain, new TerminalFragment(), "terminal").commit();
        } else if (id == R.id.nav_usb_device) {
            Toast.makeText(this, "nav_terminal", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_setting) {
            Toast.makeText(this, "nav_setting", Toast.LENGTH_SHORT).show();
            // like shared preferences
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // add new layer to placeHolder layer (de len)
            fragmentTransaction.replace(R.id.fragment_contain, new SettingFragment(), "setting");

            // back to previous State
            fragmentTransaction.addToBackStack(null);
            // commit the change.
            fragmentTransaction.commit();

        } else if (id == R.id.nav_about) {
            Toast.makeText(this, "nav_terminal", Toast.LENGTH_SHORT).show();

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
