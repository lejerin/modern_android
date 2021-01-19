package com.example.archsample.ui.detail;

import com.example.archsample.data.entity.Comment;
import com.example.archsample.data.entity.Post;

public class PostDetailCommentItem extends  PostDetailItem{

    private Comment comment;

    public PostDetailCommentItem(Comment comment){
        this.comment = comment;
    }

    @Override
    public Type getType() {
        return Type.COMMENT;
    }

    public String getName(){
        return comment.getName();
    }

    public String getBody(){
        return comment.getBody();
    }


}
