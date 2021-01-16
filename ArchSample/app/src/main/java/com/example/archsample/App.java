package com.example.archsample;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;

public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        //AppComponent 설정이 끝난 뒤,
        //컴파일 타임에 DaggerAppComponent가 생성된다.
        return DaggerAppComponent.factory().create(this);
    }
}
