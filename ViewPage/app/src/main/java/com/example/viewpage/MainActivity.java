package com.example.viewpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.viewpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding mainBinding;

    int[] layouts;
    SliderAdapter mAdapter;
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init(){
        layouts = new int[]{
                R.layout.slide_screen_1,
                R.layout.slide_screen_2,
                R.layout.slide_screen_3
        };
        mainBinding.btnNext.setOnClickListener(this);
        mainBinding.btnSkip.setOnClickListener(this);

        mAdapter = new SliderAdapter(layouts);
        mainBinding.viewPager.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==mainBinding.btnNext.getId()) {
            int current = getItem(+1);
            if (current < layouts.length) {
                // move to next screen
                mainBinding.viewPager.setCurrentItem(current);
                if (current== layouts. length-1){
                    mainBinding.btnNext.setText(R.string.cont);
                }
            } else {
                launchLoginScreen();
            }
        } else if (v.getId()==mainBinding.btnSkip.getId()) {
            launchLoginScreen();
        }
    }

    private int getItem(int i){
        return mainBinding.viewPager.getCurrentItem() + i;
    }

    private void launchLoginScreen(){
        intent1 = new Intent(this, LoginActivity.class);
        startActivity(intent1);
    }
}