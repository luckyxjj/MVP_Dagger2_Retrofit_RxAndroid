package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.present;


import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.EndObserver;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.MyScope;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data.AbsReturn;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data.DefaultData;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data.DefaultObj;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.model.TestModel;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.view.TestView;

import javax.inject.Inject;

import compartment.BasePresenter;
import rx.Observer;
import rx.Subscription;


/**
 * Created by Administrator on 2015/11/13.
 */
@MyScope
public class TestPresenter extends BasePresenter<TestView> {
    @Inject
    TestModel model;

    @Inject
    TestPresenter() {
    }

    private Subscription subscription;

    public void getValue(){
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        getBaseView().showLoading("正在搜索");
        subscription = model.getInfo()
                .subscribe(TestObserver);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

    }


    private Observer<String> TestObserver = new EndObserver<String>() {
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
                getView().show(entity);

            }
        }
    };
}
