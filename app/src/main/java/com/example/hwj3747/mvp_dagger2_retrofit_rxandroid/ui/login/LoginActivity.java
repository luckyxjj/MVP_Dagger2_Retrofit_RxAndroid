package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.R;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {/*Tip：拿到Activity*/
        return R.layout.activity_login;
    }

    @Override
    protected void onInitTitle() {/*Tip:对title的一些设置在这里做*/
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
    protected void onInitFragment() {/*Tip:这里要注意是写Activity中最外层的layout的ID,把fragment包含进来*/
        showContent(new LoginFragment(),R.id.login_activity);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
