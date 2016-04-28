package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.ui.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.R;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.base.BaseActivity;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.entity.TestEntity;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_test;
    }

    @Override
    protected void onInitTitle() {

    }

    @Override
    protected void onResolveIntent(Intent intent) {

    }

    @Override
    protected void onInitFragment() {
        showContent(new TestActivityFragment(),R.id.Layout);
    }

}
