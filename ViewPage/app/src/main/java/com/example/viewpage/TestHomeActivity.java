package com.example.viewpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.viewpage.databinding.ActivityTestHomeBinding;

public class TestHomeActivity extends AppCompatActivity {

    ActivityTestHomeBinding testHomeBinding;

    SharedPreferences sharedPref1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testHomeBinding = ActivityTestHomeBinding.inflate(getLayoutInflater());
        View view = testHomeBinding.getRoot();
        setContentView(view);
        init();


    }
    private void init(){
//        Intent intent3 = getIntent();
//        String name = intent3.getStringExtra("USER_ID");
//        testHomeBinding.txtWelcome.setText("Welcome " + name + "!");

//        User userObj = (User)getIntent().getSerializableExtra("USER_DETAILS");
//        testHomeBinding.txtWelcome.setText("Welcome " + userObj.userId + "!" + '\n' + userObj.emailId);
        sharedPref1 = getSharedPreferences("login_details", Context.MODE_PRIVATE);

        testHomeBinding.txtWelcome.setText("Welcome " + sharedPref1.getString("USER_ID",null)  + "!" + '\n' + sharedPref1.getString("EMAIL_ID",null));

    }

}