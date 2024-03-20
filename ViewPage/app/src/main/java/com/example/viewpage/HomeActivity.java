package com.example.viewpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.viewpage.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding homeBinding;
    ActionBarDrawerToggle mToggle;
    SharedPreferences sharedPref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = homeBinding.getRoot();
        init();
    }

    private void init(){
        sharedPref2 = getSharedPreferences("login_details", Context.MODE_PRIVATE);
        homeBinding.txtWelcome.setText("Welcome " + sharedPref2.getString("USER_ID", null));

        mToggle = new ActionBarDrawerToggle(this, homeBinding.drawerLayout, homeBinding.materialToolbar, R.string.nav_open, R.string.nav_close);
        homeBinding.drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        setSupportActionBar(homeBinding.materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SetNavigationDrawer();
    }

    private void SetNavigationDrawer(){
        homeBinding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag = null;
                int itemId = item.getItemId();
                if(itemId == R.id.nav_add_emp){
                    frag = new AddFragment();
                } else if (itemId == R.id.nav_delete_emp){
                    frag = new DeleteFragment();
                } else if (itemId == R.id.nav_list_emp){
                    frag = new ListFragment();
                } else if (itemId == R.id.nav_update_emp){
                }
                if(frag !=null){
                    FragmentTransaction frgTrans = getSupportFragmentManager().beginTransaction();
                    frgTrans.replace(R.id.frame, frag);
                    frgTrans.commit();
                    homeBinding.drawerLayout.closeDrawers();
                    return true;

                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}