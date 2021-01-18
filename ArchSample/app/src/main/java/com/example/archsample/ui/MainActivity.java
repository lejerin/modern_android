package com.example.archsample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.archsample.databinding.ActivityMainBinding;
import com.example.archsample.util.SingleLiveEvent;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Lazy<ActivityMainBinding> binding;

    @Inject
    @Named("errorEvent")
    SingleLiveEvent<Throwable> errorEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.get().setLifecycleOwner(this);
        errorEvent.observe(this, this::showErrorToast);


    }

    private void showErrorToast(Throwable throwable){
        throwable.printStackTrace();
        showToast(throwable.getMessage());
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}