package com.gzeinnumer.oneibasicandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.gzeinnumer.oneibasicandroidjava.databinding.ActivityMainBinding;
import com.gzeinnumer.oneibasicandroidjava.day2.Day2Activity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOnClick();
    }

    private void initOnClick() {
        binding.day2.setOnClickListener(view -> {
            intentTo(Day2Activity.class);
        });
    }

    void intentTo(Class<?> clss){
        Intent intent = new Intent(getApplicationContext(), clss);
        startActivity(intent);
    }
}