package com.kuldeep.citydirectory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.ms.square.android.expandabletextview.BuildConfig;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnview;
    ImageView imgMenuSelect;
    NavigationView navigationView;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnview = findViewById(R.id.bnView_id);
        navigationView = findViewById(R.id.navigation_id);
        mDrawerLayout = findViewById(R.id.drawer_layout_id);
        imgMenuSelect = (ImageView) findViewById(R.id.round_menu_24);
        imgMenuSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }

        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                Log.d("MainActivity", "yes"); //NO ERROR

                if (id == R.id.nav_home_id) {
                    replaceFragment(new FragmentMainActivity());
                    mDrawerLayout.closeDrawers();

                } else if (id == R.id.nav_nearby_id) {
                    replaceFragment(new FragmentNearby());
                    mDrawerLayout.closeDrawers();

                } else if (id == R.id.nav_favourite_id) {
                    replaceFragment(new FragmentFavourite());
                    mDrawerLayout.closeDrawers();

                } else if (id == R.id.nav_contact_us_id) {
                    callContactUsIntent();

                } else if (id == R.id.nav_share_app_id) {
                    shareAppLinkIntent();

                } else if (id == R.id.nav_settings_id) {
                    callSettingIntent();

                } else if (id == R.id.nav_FAQ_id) {
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.nav_exit_id) {
                    onBackPressed();

                } else {
                    return false;
                }
                return false;
            }
        });

        loadFragment(new FragmentMainActivity(), 0);
        bnview.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    loadFragment(new FragmentMainActivity(), 1);
                } else if (id == R.id.nav_location) {
                    loadFragment(new FragmentNearby(), 1);
                } else if (id == R.id.nav_favourite) {
                    loadFragment(new FragmentFavourite(), 1);
                } else {
                    loadFragment(new FragmentMainActivity(), 0);
                }
                return false;
            }
        });
    }

    private void callSettingIntent() {
        Intent i = new Intent(MainActivity.this, Settings.class);
        startActivity(i);
    }

    private void shareAppLinkIntent() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage = "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }

    public void loadFragment(Fragment fragmentObj, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.commit();
        if (flag == 0) {
            ft.add(R.id.container_frameLayout, fragmentObj);
        } else {
            ft.replace(R.id.container_frameLayout, fragmentObj);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void callContactUsIntent() {
        Intent i = new Intent(MainActivity.this, ContactUs.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);

        exitDialog.setTitle("Exit");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitDialog.setMessage("Do you really want to exit?");

        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });

        exitDialog.setNegativeButton("NO", null);
        exitDialog.show();
    }
}