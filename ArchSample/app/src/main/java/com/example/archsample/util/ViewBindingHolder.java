package com.example.archsample.util;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

//ViewDataBinding 클래스 사용을 강제하는 ViewHolder를 만듬
public class ViewBindingHolder<VBD extends ViewDataBinding>
                    extends RecyclerView.ViewHolder {

    private VBD binding;

    public ViewBindingHolder(@NonNull VBD binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public ViewBindingHolder(Context context, @LayoutRes int LayoutId){
        this(DataBindingUtil.inflate(
                LayoutInflater.from(context),
                LayoutId,
                null,
                false
        ));
    }

    public VBD getBinding(){
        return binding;
    }
}
