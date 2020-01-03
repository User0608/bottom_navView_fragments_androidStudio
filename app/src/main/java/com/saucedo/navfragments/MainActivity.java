package com.saucedo.navfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startFragments();
    }

    private void initialize(){
        this.fragment=new HomeFragment();
    }

    private void startFragments() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,fragment).commit();
        this.bottomNavigationView = findViewById(R.id.main_bottomNavigation);
        this.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_home:
                        fragment=new HomeFragment();
                        break;
                    case R.id.item_search:
                        fragment=new SearchFragment();
                        break;
                    case R.id.item_bookmark:
                        fragment=new BookmarkFragment();
                        break;
                }
                menuItem.setChecked(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,fragment).commit();
                return false;
            }
        });
    }
}
