package com.valley.wishers.tvapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.valley.wishers.tvapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.main_activity_content_container)
    protected FrameLayout mainActivityContentContainer;
    @BindView(R.id.main_drawer_layout)
    protected DrawerLayout drawerLayout;
    @BindView(R.id.main_nav_view)
    protected NavigationView navigationView;
    protected ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpNavDrawer();
        setUpBottomNavigation();
    }

    private void setUpBottomNavigation() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setUpNavDrawer() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.app_name, R.string.appbar_scrolling_view_behavior);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                     @Override
                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                         int id = item.getItemId();
                         switch (id) {
                             case R.id.location:
                                 Toast.makeText(MainActivity.this,
                                         "Location", Toast.LENGTH_SHORT).show();
                                 break;
                             case R.id.profile:
                                 Toast.makeText(MainActivity.this,
                                         "My profile", Toast.LENGTH_SHORT).show();
                                 break;
                             case R.id.settings:
                                 Toast.makeText(MainActivity.this,
                                         "Settings", Toast.LENGTH_SHORT).show();
                                 break;
                             case R.id.favorite:
                                 Toast.makeText(MainActivity.this,
                                         "Favorites", Toast.LENGTH_SHORT).show();
                                 break;
                             case R.id.feedback:
                                 Toast.makeText(MainActivity.this,
                                         "Feedback", Toast.LENGTH_SHORT).show();
                                 break;
                             case R.id.logout:
                                 Toast.makeText(MainActivity.this,
                                         "Logout", Toast.LENGTH_SHORT).show();
                                 break;
                             default:
                                 return true;
                         }
                         return false;
                     }
                 });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.main_activity_content_container, new ChannelsFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_channels:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.main_activity_content_container, ChannelsFragment.newInstance()).commit();
                    return true;
                case R.id.navigation_short_films:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.main_activity_content_container, ShortFilmsFragment.newInstance()).commit();
                    return true;
                case R.id.navigation_shows:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.main_activity_content_container, ShowsFragment.newInstance()).commit();
                    return true;
            }
            return false;
        }
    };
}
