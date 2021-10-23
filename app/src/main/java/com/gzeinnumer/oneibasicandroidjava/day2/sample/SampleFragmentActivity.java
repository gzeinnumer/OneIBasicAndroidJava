package com.gzeinnumer.oneibasicandroidjava.day2.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gzeinnumer.oneibasicandroidjava.R;

public class SampleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_fragment);

        setTitle(getClass().getSimpleName());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fr_2, Day2Fragment.newInstance())
                    .commitNow();
        }
    }
}