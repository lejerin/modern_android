package com.example.archsample.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.archsample.ui.detail.PostDetailViewModel;
import com.example.archsample.ui.post.PostViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

//ViewModel과 관련된 내용을 오브젝트 그래프로 관리
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);


    //오브젝트 그래프에 멀티 바인딩 하도록
    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    abstract ViewModel bindsPostViewModel(PostViewModel postViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailViewModel.class)
    abstract ViewModel bindsPostDetailViewModel(PostDetailViewModel postDetailViewModel);

}