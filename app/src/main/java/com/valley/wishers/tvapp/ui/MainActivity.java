package com.valley.wishers.tvapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.valley.wishers.tvapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.main_activity_content_container)
    protected FrameLayout mainActivityContentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.main_activity_content_container, new ChannelsFragment()).commit();
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
