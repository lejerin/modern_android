package com.example.archsample.di;

import javax.inject.Named;
import javax.inject.Singleton;

import android.app.Application;
import android.content.Context;


import com.example.archsample.App;
import com.example.archsample.util.SingleLiveEvent;

import dagger.Module;
import dagger.Provides;

//viewModelModule을 애플리케이션 범위로 관리하도록 AppModule에 포함한다.
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Application provideApp(App app) {
        return app;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(App app) {
        return app;
    }

    //앱의 오류 이벤트를 처리하는 SingleLiveEvent
    @Singleton
    @Provides
    @Named("errorEvent")
    SingleLiveEvent<Throwable> provideErrorEvent(){
        return new SingleLiveEvent<>();
    }

}