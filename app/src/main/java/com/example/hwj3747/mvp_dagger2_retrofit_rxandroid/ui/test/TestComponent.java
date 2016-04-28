package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.ui.test;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.AppComponent;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.MyScope;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.model.TestModel;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.present.TestPresenter;

import compartment.HasPresenter;
import dagger.Component;

/**
 * Created by Administrator on 2015/11/13.
 */
@Component(
        dependencies = AppComponent.class, modules = TestModel.class
)
@MyScope
public interface TestComponent extends HasPresenter<TestPresenter> {
    void inject(TestActivityFragment fragment);
}
