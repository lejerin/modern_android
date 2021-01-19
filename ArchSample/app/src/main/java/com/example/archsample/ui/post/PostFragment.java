package com.example.archsample.ui.post;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.archsample.R;
import com.example.archsample.databinding.FragmentPostBinding;
import com.example.archsample.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerFragment;


public class PostFragment extends DaggerFragment {

    @Inject
    FragmentPostBinding binding;
    @Inject
    AppViewModelFactory viewModelFactory;
    @Inject
    PostAdapter adapter;
    @Inject
    LinearLayoutManager layoutManager;
    @Inject
    Lazy<NavController> navController;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //LifeCycle Owner 등록
        binding.setLifecycleOwner(getViewLifecycleOwner());
        //RecyclerView Adapter 지정
        binding.recyclerView.setAdapter(adapter);
        //RecyclerView 레이아웃 매니저 지정
        binding.recyclerView.setLayoutManager(layoutManager);
        //바인딩 클래스에 viewModel 연결
        binding.setViewModel(viewModel);
        //viewModel이 가진 게시 글 목록을 구독하여 Adapter에 반영
        viewModel.getLivePosts()
                .observe(getViewLifecycleOwner(), list -> adapter.setItems(list));

        //게시글이 클릭 되었을 때 게시글 상세 화면 목적지로 이동
        viewModel.getPostClickEvent()
                .observe(getViewLifecycleOwner(), postItem ->
                        navController.get().navigate(PostFragmentDirections
                                .actionPostFragmentToPostDetailFragment(postItem.getPost())));
    }
}