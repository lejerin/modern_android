package com.example.archsample.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archsample.databinding.FragmentPostBinding;
import com.example.archsample.databinding.FragmentPostDetailBinding;
import com.example.archsample.di.ApplicationContext;
import com.example.archsample.di.FragmentScope;
import com.example.archsample.ui.post.PostFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class PostDetailModule {

    @Provides
    @FragmentScope
    FragmentPostDetailBinding provideBinding(@ApplicationContext Context context){
        return FragmentPostDetailBinding.inflate(LayoutInflater.from(context), null, false);
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

    @Provides
    @FragmentScope
    NavController provideNavController(PostDetailFragment fragment){
        return NavHostFragment.findNavController(fragment);
    }

}
