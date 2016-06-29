package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.ui.login;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.AppComponent;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.MyScope;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.model.LoginModel;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.present.LoginPresenter;

import compartment.HasPresenter;
import dagger.Component;

/**
 * Created by Administrator on 2015/11/13.
 */
@Component(
        dependencies = AppComponent.class, modules = LoginModel.class/*Tip：改成你自己的Model*/
)
@MyScope
public interface LoginComponent extends HasPresenter<LoginPresenter> {/*Tip：改成你自己的Presenter*/
    void inject(LoginFragment fragment);/*Tip：改成你自己的Fragment*/
}
