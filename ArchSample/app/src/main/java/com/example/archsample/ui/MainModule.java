package com.example.archsample.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.example.archsample.R;
import com.example.archsample.di.ActivityContext;
import com.example.archsample.di.ActivityScope;

import dagger.Module;
import dagger.Provides;
import com.example.archsample.databinding.ActivityMainBinding;

@Module
public abstract class MainModule {

    @Provides
    @ActivityScope
    static ActivityMainBinding provideBinding(MainActivity activity) {
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

    @Provides
    @ActivityContext
    static Context provideContext(MainActivity activity) {
        return activity;
    }

}
