package com.example.archsample.ui.post;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.archsample.BR;
import com.example.archsample.R;
import com.example.archsample.data.entity.Post;
import com.example.archsample.util.ViewBindingHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PostAdapter extends RecyclerView.Adapter<ViewBindingHolder> {

    private final List<PostItem> items = new ArrayList<>();

    @Inject
    public PostAdapter(){

    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.view_post;
    }

    //뷰 홀더 생성
    @NonNull
    @Override
    public ViewBindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewBindingHolder(parent.getContext(), viewType);
    }

    //뷰 홀더와 뷰 모델을 바인딩한다.
    /*
    구체적인 결합 클래스를 알 수 없는 때도 있습니다.
    예를 들어 임의의 레이아웃에 작동하는 RecyclerView.Adapter는 특정 결합 클래스를 인식하지 못합니다.
    따라서 이 어댑터는 onBindViewHolder() 메서드를 호출하는 동안에도 계속해서 결합 값을 할당해야 합니다.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewBindingHolder holder, int position){
        holder.getBinding().setVariable(BR.item, items.get(position));
        /*
        데이터 결합 라이브러리는 모듈 패키지에 BR이라는 클래스를 생성합니다.
        이 클래스에는 데이터 결합에 사용된 리소스의 ID가 포함되어 있습니다.
        위의 예에서 라이브러리는 BR.item 변수를 자동으로 생성합니다.
         */
        holder.getBinding().executePendingBindings();
        /*
        변수 또는 관찰 가능한 객체가 변경될 때 결합은 다음 프레임 이전에 변경되도록 예약됩니다.
        하지만 결합이 즉시 실행되어야 하는 때도 있습니다.
        이럴 때 강제로 실행하려면 executePendingBindings() 메서드를 사용하세요.
         */
    }

    public void setItems(List<PostItem> items){
        this.items.clear();
        this.items.addAll(items);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
