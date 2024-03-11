package com.example.yashmistrytask4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import com.example.yashmistrytask4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    // binding
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // setting up RatingBar for restaurant 1,2,3,4,5
        binding.res1.rtApp1.setNumStars(5);
        binding.res1.rtApp1.setRating(0);
        binding.res1.txtRatingSelected1.setText(String.valueOf(binding.res1.rtApp1.getRating()));

        binding.res2.rtApp2.setNumStars(5);
        binding.res2.rtApp2.setRating(0);
        binding.res2.txtRatingSelected2.setText(String.valueOf(binding.res2.rtApp2.getRating()));

        binding.res3.rtApp3.setNumStars(5);
        binding.res3.rtApp3.setRating(0);
        binding.res3.txtRatingSelected3.setText(String.valueOf(binding.res3.rtApp3.getRating()));

        binding.res4.rtApp4.setNumStars(5);
        binding.res4.rtApp4.setRating(0);
        binding.res4.txtRatingSelected4.setText(String.valueOf(binding.res4.rtApp4.getRating()));

        binding.res5.rtApp5.setNumStars(5);
        binding.res5.rtApp5.setRating(0);
        binding.res5.txtRatingSelected5.setText(String.valueOf(binding.res5.rtApp5.getRating()));

        // calling listener
        setListeners();
    }

    // method for RatingBar listeners
    private void setListeners() {
        binding.res1.rtApp1.setOnRatingBarChangeListener(this);
        binding.res2.rtApp2.setOnRatingBarChangeListener(this);
        binding.res3.rtApp3.setOnRatingBarChangeListener(this);
        binding.res4.rtApp4.setOnRatingBarChangeListener(this);
        binding.res5.rtApp5.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
        // Conditional statement to check RatingBar change
        if (ratingBar.getId() == binding.res1.rtApp1.getId()) {
            binding.res1.txtRatingSelected1.setText(String.valueOf(rating));
        } else if (ratingBar.getId() == binding.res2.rtApp2.getId()) {
            binding.res2.txtRatingSelected2.setText(String.valueOf(rating));
        } else if (ratingBar.getId() == binding.res3.rtApp3.getId()) {
            binding.res3.txtRatingSelected3.setText(String.valueOf(rating));
        } else if (ratingBar.getId() == binding.res4.rtApp4.getId()) {
            binding.res4.txtRatingSelected4.setText(String.valueOf(rating));
        } else if (ratingBar.getId() == binding.res5.rtApp5.getId()) {
            binding.res5.txtRatingSelected5.setText(String.valueOf(rating));
        }
    }
}