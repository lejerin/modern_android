package com.example.archsample.ui.post;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.archsample.R;
import com.example.archsample.databinding.FragmentPostBinding;
import com.example.archsample.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class PostFragment extends DaggerFragment {

    @Inject
    FragmentPostBinding binding;
    @Inject
    AppViewModelFactory viewModelFactory;

    PostViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ViewModel 객체를 요청
        viewModel = new ViewModelProvider(this, viewModelFactory).
                get(PostViewModel.class);
        if(savedInstanceState == null){
            //데이터 요청, 프래그먼트가 재생성 되었을 때는 요청하지 않는다.
            viewModel.loadPosts();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return binding.getRoot();
    }
}