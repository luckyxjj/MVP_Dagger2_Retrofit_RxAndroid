package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.model;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.SchedulerProvider;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data.LoginService;

import javax.inject.Inject;

import dagger.Module;
import rx.Observable;

/**
 * Created by hwj3747 on 2016/4/5.
 */
@Module
public class LoginModel {
    private final SchedulerProvider schedulerProvider = SchedulerProvider.DEFAULT;
    private final LoginService mService = new LoginService();/*Tip:改成自己的Service*/

    @Inject
    public LoginModel() {
    }

    public Observable<String> login(String name,String pwd){
        return mService.getApi().validateLogin(name,pwd) /*Tip：这里调用Service中的方法*/
                .compose(schedulerProvider.applySchedulers());
    }
}