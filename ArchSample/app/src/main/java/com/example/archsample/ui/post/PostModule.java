package com.example.archsample.ui.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archsample.databinding.FragmentPostBinding;
import com.example.archsample.di.ApplicationContext;
import com.example.archsample.di.FragmentScope;

import dagger.Provides;

public class PostModule {

    @Provides
    @FragmentScope
    FragmentPostBinding provideBinding(@ApplicationContext Context context){
        return FragmentPostBinding.inflate(LayoutInflater.from(context), null, false);
    }

    //RecyclerView용 레이아웃 매니저
    @Provides
    @FragmentScope
    LinearLayoutManager provideLinearLayoutManager(@ApplicationContext Context context){
        return new LinearLayoutManager(context){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }

}
