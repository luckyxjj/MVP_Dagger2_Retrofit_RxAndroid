package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.ui.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.R;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.base.BaseActivity;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_test;
    }

    @Override
    protected void onInitTitle() {
        mAppBar.canFinishActivity();
        mAppBar.setTitleText("测试");
        mAppBar.setBackgroundColor(Color.parseColor("#f7f7f7"));
        mAppBar.setTitleTextColor(Color.parseColor("#0a0a0a"));
        mAppBar.setNavigationIcon(R.drawable.ico_arrow_l);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResolveIntent(Intent intent) {

    }

    @Override
    protected void onInitFragment() {
        showContent(new TestActivityFragment(),R.id.Layout);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
