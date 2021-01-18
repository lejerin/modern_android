package com.example.archsample.ui.post;

import androidx.annotation.NonNull;

import com.example.archsample.data.entity.Post;

//View에 해당하는 Recyclerview.ViewHolder 인스턴스의 ViewModel 역할을 한다
public class PostItem {

    @NonNull
    private final Post post;

    public PostItem(@NonNull Post post){
        this.post = post;
    }

    @NonNull
    public  Post getPost(){
        return post;
    }

    public String getTitle(){
        return post.getTitle();
    }
}
