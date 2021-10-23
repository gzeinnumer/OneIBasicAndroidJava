package com.gzeinnumer.oneibasicandroidjava.day2.sample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzeinnumer.oneibasicandroidjava.R;

public class Day2Fragment extends Fragment {

    public Day2Fragment() {
        // Required empty public constructor
    }

    public static Day2Fragment newInstance() {
        return new Day2Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.day2_fragment_main, container, false);
    }
}