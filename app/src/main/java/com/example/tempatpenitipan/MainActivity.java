package com.example.tempatpenitipan;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.tempatpenitipan.adapterlistener.AdapterListenerActivity;
import com.example.tempatpenitipan.rincian.Rincian;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;
    Dialog yaa;
    Dialog tidaak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        // tampilan default awal ketika aplikasii dijalankan
        if (savedInstanceState == null) {
            fragment = new Home();
            callFragment(fragment);
        }



    }


    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Untuk memanggil layout dari menu yang dipilih
        if (id == R.id.nav_view) {
            fragment = new Home();
            callFragment(fragment);
        } else if (id == R.id.nav_gallery) {
            Intent a = new Intent(MainActivity.this, Rincian.class);
            startActivity(a );
        } else if (id == R.id.nav_tools) {
            Intent ak = new Intent(MainActivity.this, AdapterListenerActivity.class);
            startActivity(ak );
            callFragment(fragment);
        } else if (id == R.id.nav_share) {
            Intent aku = new Intent(MainActivity.this,MainPage.class);
            startActivity(aku);
        } else if (id == R.id.nav_send) {
            Intent intentku = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intentku);
        }else if (id == R.id.nav_keluar){
            showCustomDialog();

        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showCustomDialog() {

        yaa = new Dialog(MainActivity.this);
        yaa.setContentView(R.layout.keluar);

        yaa.show();

        Button ba = (Button) yaa.findViewById(R.id.buttonok);
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();

            }
        });
        Button al = (Button) yaa.findViewById(R.id.buttonok2);
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yaa.cancel();
            }
        });


    }



    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }

}