package com.example.yashmistrytask2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yashmistrytask2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.registerBtn.setOnClickListener(this);
        binding.loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.registerBtn)
        {
            String name, email, address;
            name = String.valueOf(binding.name.getText());
            email = String.valueOf(binding.email.getText());
            address = String.valueOf(binding.address.getText());

            Toast.makeText(getApplicationContext(),name+'\n'+email+'\n'+address, Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()== R.id.loginBtn)
        {
            Toast.makeText(getApplicationContext(), "Validating the credentials", Toast.LENGTH_SHORT).show();
        }
    }
}