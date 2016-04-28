package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.util.rximageloader.cacheobservers;


import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.util.rximageloader.Data;

import rx.Observable;

/**
 * Created by Liyanshun on 2015/8/24.
 */
public abstract class CacheObservable {
    public abstract Observable<Data> getObservable(String url);
}
