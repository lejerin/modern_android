package com.example.archsample.ui.post;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.archsample.data.PostService;
import com.example.archsample.data.entity.Post;
import com.example.archsample.util.SingleLiveEvent;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

public class PostViewModel extends AndroidViewModel
                        implements PostItem.EventListener{

    @NonNull
    private final PostService postService;
    @NonNull
    private final SingleLiveEvent<Throwable> errorEvent;

    private final SingleLiveEvent<PostItem> posClickEvent = new SingleLiveEvent<>();

    //RecyclerView에 포현할 아이템들을 LiveData로 관리
    private final MutableLiveData<List<PostItem>> livePosts = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);

    @Inject
    public PostViewModel(@NonNull Application application,
                         PostService postService,
                         @Named("errorEvent") SingleLiveEvent<Throwable> errorEvent){
        super(application);
        Timber.d("PostViewModel created");
        //오브젝트 그래프로부터 생성자 주입
        this.postService = postService;
        this.errorEvent = errorEvent;
    }

    //게시글 목록 불러오기
    public void loadPosts(){
        compositeDisposable.add(postService.getPost()
                .flatMapObservable(Observable::fromIterable)
                .map(post -> new PostItem(post, this))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(item -> loading.postValue(false))
                .subscribe(livePosts::setValue, errorEvent::setValue)
        );
    }

    @NonNull
    public MutableLiveData<List<PostItem>> getLivePosts(){
        return livePosts;
    }

    /*
    ViewModel은 생명 주기를 알고 동장한다.
    뷰 모델이 파괴될 때, RxJava의 DISPOSABLE과 같은
    리소스 등을 해제할 수 있도록 한다.
     */

    @Override
    protected void onCleared() {
        super.onCleared();
        Timber.d("onCleared");
        compositeDisposable.dispose();
    }

    public MutableLiveData<Boolean> getLoading(){
        return loading;
    }

    @Override
    public void onPostClick(PostItem postItem) {
        //Fragment 로 이벤트를 전달하도록
        //SingleLiveEvent의 값을 변경한다
        posClickEvent.setValue(postItem);
    }

    public SingleLiveEvent<PostItem> getPostClickEvent(){
        return posClickEvent;
    }
}
