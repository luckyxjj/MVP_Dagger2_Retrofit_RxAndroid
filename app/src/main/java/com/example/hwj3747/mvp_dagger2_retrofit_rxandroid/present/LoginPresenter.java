package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.present;


import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.EndObserver;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.MyScope;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.model.LoginModel;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.model.TestModel;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.view.LoginView;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.view.TestView;

import javax.inject.Inject;

import compartment.BasePresenter;
import rx.Observer;
import rx.Subscription;


/**
 * Created by Administrator on 2015/11/13.
 */
@MyScope /*这个注解记得加*/
public class LoginPresenter extends BasePresenter<LoginView> {
    @Inject
    LoginModel model;/*Tip：把Model引过来  注解别忘了*/
    @Inject
    LoginPresenter() {
    }
    /*Tip：定义观察者和被观察者之间的桥梁*/
    private Subscription subscription;

    public void getValue(String name,String pwd){
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        getBaseView().showLoading("正在搜索");
        subscription = model.login(name,pwd)
                .subscribe(LoginObserver);
                /*Tip:把从Model中拿到的值变成一个被观察者对象，用LoginObserver来订阅（subscribe）它，当被观察者获得数据就会交给LoginObserver处理*/

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

    }

    /*Tip：定义观察者*/
    private Observer<String> LoginObserver = new EndObserver<String>() {
        @Override
        public void onEnd() {
            if (getBaseView() != null) {
                getBaseView().hideLoading();
            }
        }

        @Override
        public void onMyNext(String entity) {
            if (getView() != null){
                getBaseView().hideLoading();
                System.out.println(entity);
                getView().show(entity);/*Tip:观察者获得值后通过这个接口把值传递到Fragment中*/

            }
        }
    };
}
