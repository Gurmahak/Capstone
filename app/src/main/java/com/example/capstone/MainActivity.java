package com.example.capstone;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.capstone.ui.dashboard.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
          //      R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_search)
            //    .build();
        //NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_view);
        //NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);


        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_view, fragment)
                    .commit();

            return true;
        }
        return false;
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch(menuItem.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new DashboardFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new NotificationFragment();
                break;

            case R.id.navigation_search:
                fragment = new SearchFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
