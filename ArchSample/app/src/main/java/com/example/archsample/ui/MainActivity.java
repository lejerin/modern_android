package com.example.archsample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.archsample.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Lazy<ActivityMainBinding> binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.get().setLifecycleOwner(this);



    }
}