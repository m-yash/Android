package com.example.yashmistrytask5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.yashmistrytask5.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding detailsBinding;
    SharedPreferences sharedPref1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailsBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = detailsBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init(){

        // fetching data from shared preference
        sharedPref1 = getSharedPreferences("product_details", Context.MODE_PRIVATE);

        // displaying result on textview
        detailsBinding.txtDetails.setText("Product Details\n\n" + "Product Code: "+ sharedPref1.getString("PRODUCT_CODE",null)  + '\n' + "Product Name: "+ sharedPref1.getString("PRODUCT_NAME",null) + '\n' + "Product Price: $"+ sharedPref1.getString("PRODUCT_PRICE",null));

    }
}