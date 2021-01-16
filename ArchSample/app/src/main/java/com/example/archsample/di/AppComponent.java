package com.example.archsample.di;

import com.example.archsample.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityModule.class, // 액티비티 스코프 모듈
        AppModule.class // 애플리케이션 스코프 모듈
})

//안드로이드 애플리케이션 컴포넌트 정의
public interface AppComponent extends AndroidInjector<App>{
    //안드로이드 애플리케이션 컴포넌트 팩토리 정의
    @Component.Factory
    abstract class Factory implements AndroidInjector.Factory<App>{

    }
}
