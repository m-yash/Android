package com.example.viewpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.viewpage.databinding.ActivityLoginBinding;
import com.example.viewpage.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityLoginBinding loginBinding;
    int[] layouts;
    SliderAdapter mAdapter;

    Intent intent2;

    SharedPreferences sharedPref1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = loginBinding.getRoot();
        setContentView(view);
        init();
        intent2 = new Intent(this, TestHomeActivity.class);
//        intent2.putExtra("USER_ID", loginBinding.edtUserId.getText().toString().trim());
//        startActivity(intent2);
    }



    @Override
    public void onClick(View view) {
        if(view.getId() == loginBinding.btnLogin.getId()){
            if(loginBinding.edtUserId.getText().toString().trim().equals("yash") && loginBinding.edtPasswd.getText().toString().trim().equals("yash")){
//                intent2 = new Intent(this, TestHomeActivity.class);
////                intent2.putExtra("USER_ID", loginBinding.edtUserId.getText().toString().trim());
//                User objUser = new User(loginBinding.edtUserId.getText().toString().trim(), loginBinding.edtEmailid.getText().toString().trim());
//                intent2.putExtra("USER_DETAILS", objUser);

                SharedPreferences.Editor editor1 = sharedPref1.edit();

                editor1.putString("USER_ID",  loginBinding.edtUserId.getText().toString().trim());
                editor1.putString("EMAIL_ID",  loginBinding.edtEmailid.getText().toString().trim());
                editor1.commit();


                startActivity(intent2);
            } else {
//                Toast.makeText(getApplicationContext(), "Wrong credentials", Toast.LENGTH_LONG).show();
            }
            LoginFailDialog dialog1 = new LoginFailDialog();
            dialog1.show(getSupportFragmentManager(), "invalid");

        }
    }

    private void init(){
        loginBinding.btnLogin.setOnClickListener(this);
        sharedPref1 = getSharedPreferences("login_details", Context.MODE_PRIVATE);
    }
}