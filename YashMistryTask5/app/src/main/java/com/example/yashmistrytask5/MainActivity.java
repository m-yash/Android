package com.example.yashmistrytask5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yashmistrytask5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding mainBinding;

    Intent intent1;
    SharedPreferences sharedPref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        init();
        intent1 = new Intent(this, DetailsActivity.class);
    }


    private void init(){
        mainBinding.btnSubmit.setOnClickListener(this);

        // setting shared preference name
        sharedPref1 = getSharedPreferences("product_details", Context.MODE_PRIVATE);
    }

    // submit button onclick event
    @Override
    public void onClick(View view) {
        if(view.getId() == mainBinding.btnSubmit.getId()){

            // exception handling
            if(!mainBinding.edtProductCode.getText().toString().trim().equals("") && !mainBinding.edtProductName.getText().toString().trim().equals("") && !mainBinding.edtProductPrice.getText().toString().trim().equals("")){

                // initializing intent
                intent1 = new Intent(this, DetailsActivity.class);

                // saving data in shared preference
                SharedPreferences.Editor editor1 = sharedPref1.edit();

                editor1.putString("PRODUCT_CODE",  mainBinding.edtProductCode.getText().toString().trim());
                editor1.putString("PRODUCT_NAME",  mainBinding.edtProductName.getText().toString().trim());
                editor1.putString("PRODUCT_PRICE",  mainBinding.edtProductPrice.getText().toString().trim());
                editor1.commit();

                // intent
                startActivity(intent1);
            } else {
                // error message
                Toast.makeText(getApplicationContext(), "Invalid Details", Toast.LENGTH_LONG).show();
            }
        }
    }
}