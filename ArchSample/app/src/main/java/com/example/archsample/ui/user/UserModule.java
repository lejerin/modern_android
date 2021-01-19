package com.example.archsample.ui.user;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.archsample.databinding.FragmentUserBinding;
import com.example.archsample.di.ActivityContext;
import com.example.archsample.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @Provides
    @FragmentScope
    FragmentUserBinding provideBinding(@ActivityContext Context context){
        return FragmentUserBinding.inflate(LayoutInflater.from(context));
    }
}