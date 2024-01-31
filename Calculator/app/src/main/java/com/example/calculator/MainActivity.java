package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Variable declaration
//    EditText firstNumber;
//    EditText secondNumber;
//    TextView result;
//    Button sum, product;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btnFindSum.setOnClickListener(this);
        binding.btnFindProduct.setOnClickListener(this);
        // initiating buttons
//        firstNumber = (EditText) findViewById(R.id.edtFirstNumber);
//        secondNumber = (EditText) findViewById(R.id.edtSecondNumber);
//        result = (TextView) findViewById(R.id.txtResult);
//        sum = (Button) findViewById(R.id.btnFindSum);
//        product = (Button) findViewById(R.id.btnFindProduct);
//        sum.setOnClickListener(this);
//        product.setOnClickListener(this);

//        {
//            @Override
//            public void onClick(View view) {
//            int first, second, res;
//            first = Integer.parseInt(String.valueOf(firstNumber.getText()));
//            second = Integer.parseInt(String.valueOf(secondNumber.getText()));
//            res = first + second;
//            result.setText(String.valueOf(res));
//            Toast.makeText(getApplicationContext(), "sum: "+ res, Toast.LENGTH_SHORT).show();
//        }
//        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnFindSum)
        {
            int first, second, res;
//            first = Integer.parseInt(String.valueOf(firstNumber.getText()));
//            second = Integer.parseInt(String.valueOf(secondNumber.getText()));

            first = Integer.parseInt(String.valueOf(binding.edtFirstNumber.getText()));
            second = Integer.parseInt(String.valueOf(binding.edtSecondNumber.getText()));
            res = first + second;
//            result.setText(String.valueOf(res));
            binding.txtResult.setText(String.valueOf(res));
            Toast.makeText(getApplicationContext(), "sum: "+res, Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()== R.id.btnFindProduct)
        {
            int first, second, res;
//            first = Integer.parseInt(String.valueOf(firstNumber.getText()));
//            second = Integer.parseInt(String.valueOf(secondNumber.getText()));
            first = Integer.parseInt(String.valueOf(binding.edtFirstNumber.getText()));
            second = Integer.parseInt(String.valueOf(binding.edtSecondNumber.getText()));
            res = first * second;
//            result.setText(String.valueOf(res));
            binding.txtResult.setText(String.valueOf(res));
            Toast.makeText(getApplicationContext(), "product: "+ res, Toast.LENGTH_SHORT).show();
        }
    }
}