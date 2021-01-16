package com.example.archsample.data;

import com.example.archsample.data.entity.Post;
import com.example.archsample.data.entity.User;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("/users/{userId}")
    Single<User> getUser(@Path("userId") long userId);
}
