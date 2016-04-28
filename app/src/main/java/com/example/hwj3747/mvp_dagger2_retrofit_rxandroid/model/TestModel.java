package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.model;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.SchedulerProvider;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data.AbsService;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by hwj3747 on 2016/4/5.
 */
@Module
public class TestModel {
    private final SchedulerProvider schedulerProvider = SchedulerProvider.DEFAULT;
    private final AbsService mService = new AbsService();

    @Inject
    public TestModel() {
    }
}