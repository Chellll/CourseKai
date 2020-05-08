package com.example.coursekai.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.coursekai.R;
import com.example.coursekai.databinding.ActivityMainBinding;
import com.example.coursekai.fragment.main.FragmentIntro;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction()
                .replace(binding.container.getId(), FragmentIntro.newInstance())
                .commit();

    }
}