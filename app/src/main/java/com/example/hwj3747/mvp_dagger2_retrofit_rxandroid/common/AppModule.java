package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    public SchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.DEFAULT;
    }

    @Provides
    public SchedulerProvider providesecondSchedulerProvider() {
        return SchedulerProvider.DEFAULT;
    }

    @Provides
    @Nullable
    public LayoutInflaterFactory provideLayoutInflaterFactory() {
        return null;
    }
}
