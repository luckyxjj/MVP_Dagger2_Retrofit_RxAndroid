package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common;


import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(
        modules = AppModule.class
)
@Singleton
public interface AppComponent {
    BaseActivity inject(BaseActivity activity);
}
