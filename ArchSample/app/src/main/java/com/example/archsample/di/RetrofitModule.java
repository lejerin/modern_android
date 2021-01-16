package com.example.archsample.di;

import com.example.archsample.data.CommentService;
import com.example.archsample.data.PostService;
import com.example.archsample.data.UserService;

import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

public class RetrofitModule {
    @Provides
    @Reusable
    PostService providerPostService(Retrofit retrofit){
        return retrofit.create(PostService.class);
    }

    @Provides
    @Reusable
    UserService provideUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }

    @Provides
    @Reusable
    CommentService provideCommentService(Retrofit retrofit){
        return retrofit.create(CommentService.class);
    }
}
