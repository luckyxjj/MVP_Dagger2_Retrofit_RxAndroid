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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

    }


    private Observer<AbsReturn<DefaultData,DefaultObj>> ShowObserver = new EndObserver<AbsReturn<DefaultData,DefaultObj>>() {
        @Override
        public void onEnd() {
            if (getBaseView() != null) {
                getBaseView().hideLoading();
            }
        }

        @Override
        public void onMyNext(AbsReturn<DefaultData,DefaultObj> entity) {
            getBaseView().hideLoading();
        }
    };
}
