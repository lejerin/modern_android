package com.example.archsample.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.example.archsample.ui.detail.PostDetailViewModel;
import com.example.archsample.ui.post.PostViewModel;
import com.example.archsample.ui.user.UserViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

//ViewModel과 관련된 내용을 오브젝트 그래프로 관리
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    abstract ViewModel bindsPostViewModel(PostViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailViewModel.class)
    abstract ViewModel bindsPostDetailViewModel(PostDetailViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindsUserViewModel(UserViewModel viewModel);

}
