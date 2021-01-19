package com.example.archsample.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.example.archsample.R;
import com.example.archsample.di.ActivityContext;
import com.example.archsample.di.ActivityScope;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

import com.example.archsample.databinding.ActivityMainBinding;
import com.example.archsample.di.FragmentScope;
import com.example.archsample.ui.detail.PostDetailFragment;
import com.example.archsample.ui.detail.PostDetailModule;
import com.example.archsample.ui.post.PostFragment;
import com.example.archsample.ui.post.PostModule;

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


    //서브 컴포넌트 정의
    @FragmentScope
    @ContributesAndroidInjector(modules = PostModule.class)
    abstract PostFragment getPostFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = PostDetailModule.class)
    abstract PostDetailFragment getPostDetailFragment();
}
