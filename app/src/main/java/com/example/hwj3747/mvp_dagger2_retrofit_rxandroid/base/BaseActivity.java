package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.KeyEvent;
import android.view.LayoutInflater;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.App;
import com.haiyangroup.library.absBase.AbsBaseActivity;
import com.haiyangroup.library.utils.SharedPreferencesUtil;

import javax.inject.Inject;

/**
 * 根据应用自定义功能
 *
 * @author limj
 */
public abstract class BaseActivity extends AbsBaseActivity {
    @Inject
    @Nullable
    protected LayoutInflaterFactory layoutInflaterHook;
    private BaseFragment mActiveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getAppComponent(this).inject(this);

        if (layoutInflaterHook != null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            LayoutInflaterCompat.setFactory(layoutInflater, layoutInflaterHook);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onRestoreData(Bundle savedInstanceState) {
                mActiveFragment = (BaseFragment) getSupportFragmentManager().getFragment(
                savedInstanceState, BaseFragment.class.getName());

    }

    @Override
    protected void onPrepareData() {

    }

    @Override
    protected void onSaveData(Bundle outState) {
        getSupportFragmentManager()
                .putFragment(outState, BaseFragment.class.getName(), mActiveFragment);

    }

    public void showContent(BaseFragment fragment,int id) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();

        if (!fragment.isAdded()) {
            ft.add(id, fragment);
            if (null != mActiveFragment) {
                ft.hide(mActiveFragment);
            }
        } else {
            ft.hide(getActiveFragment()).show(fragment);
        }
        ft.commitAllowingStateLoss();
        mActiveFragment = fragment;
        SharedPreferencesUtil.getInstance(this).putInt("mActiveFragment", mActiveFragment.getId());
    }

    public BaseFragment getActiveFragment() {
        if (null == mActiveFragment) {
            int id = SharedPreferencesUtil.getInstance(this).getInt("mActiveFragment", -1);
            mActiveFragment = (BaseFragment) mFragmentManager.findFragmentById(id);
        }
        return mActiveFragment;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
