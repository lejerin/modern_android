package com.example.archsample.ui.post;

import androidx.annotation.NonNull;

import com.example.archsample.data.entity.Post;

import java.util.EventListener;

//View에 해당하는 Recyclerview.ViewHolder 인스턴스의 ViewModel 역할을 한다
//화면 전환, 다이얼로그 노출 등 안드로이드 시스템과 관력된 작업을 할 수 없는 레이어
public class PostItem {

    @NonNull
    private final Post post;

    @NonNull
    private final EventListener eventListener;

    public PostItem(@NonNull Post post, EventListener eventListener){
        this.post = post;
        this.eventListener = eventListener;
    }

    @NonNull
    public  Post getPost(){
        return post;
    }

    public String getTitle(){
        return post.getTitle();
    }

    @NonNull
    public EventListener getEventListener(){
        return eventListener;
    }

    public interface EventListener{
        void onPostClick(PostItem postItem);
    }


}
